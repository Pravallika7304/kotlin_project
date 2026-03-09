package com.example.itemapp.repository

import com.example.itemapp.network.RetrofitInstance

class ItemRepository {

    suspend fun getItems() =
        RetrofitInstance.api.getItems()
}
