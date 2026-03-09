package com.example.itemapp.storage

import android.content.Context

class PreferenceManager(context:Context){

    private val pref =
        context.getSharedPreferences("item_pref",Context.MODE_PRIVATE)

    fun saveUser(name:String){
        pref.edit().putString("username",name).apply()
    }

    fun getUser():String?{
        return pref.getString("username","")
    }

}
