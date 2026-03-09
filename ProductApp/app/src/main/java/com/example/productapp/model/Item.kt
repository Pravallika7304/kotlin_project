package com.example.itemapp.model

data class Item(
    val rating: Double = 0.0,
    val id:Int,
    val title:String,
    val price:Double,
    val description:String,
    val image:String
)
