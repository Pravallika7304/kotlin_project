package com.example.itemapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ItemDetailScreen(title:String,price:String,description:String){

    Column(modifier=Modifier.padding(16.dp)){

        Text("Title: $title")

        Spacer(modifier=Modifier.height(8.dp))

        Text("Price: ₹$price")

        Spacer(modifier=Modifier.height(8.dp))

        Text("Description: $description")

    }

}
