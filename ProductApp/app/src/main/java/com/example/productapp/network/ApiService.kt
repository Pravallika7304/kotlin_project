package com.example.itemapp.network

import com.example.itemapp.model.Item
import retrofit2.http.GET

interface ApiService {
    @GET("items")
    suspend fun getItems():List<Item>
}
