
package com.example.itemapp.viewmodel

import android.content.Context
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.itemapp.model.Item
import com.example.itemapp.repository.ItemRepository
import kotlinx.coroutines.launch
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ItemViewModel(private val context: Context): ViewModel(){

    private val repository = ItemRepository()
    private val prefs = context.getSharedPreferences("items_pref", Context.MODE_PRIVATE)
    private val gson = Gson()

    var itemList = mutableStateListOf<Item>()

    init{
        loadItems()
    }

    fun fetchItems(){
        viewModelScope.launch {
            try{
                val result = repository.getItems()
                itemList.clear()
                itemList.addAll(result)
                saveItems()
            }catch (e:Exception){
                e.printStackTrace()
            }
        }
    }

    fun addItem(item:Item){
        itemList.add(item)
        saveItems()
    }

    fun deleteItem(item: Item){
        itemList.remove(item)
        saveItems()
    }

    private fun saveItems(){
        val json = gson.toJson(itemList.toList())
        prefs.edit().putString("items_json", json).apply()
    }

    private fun loadItems(){
        val json = prefs.getString("items_json", null)
        if(json!=null){
            val type = object: TypeToken<List<Item>>(){}.type
            val list: List<Item> = gson.fromJson(json,type)
            itemList.addAll(list)
        }
    }
}
