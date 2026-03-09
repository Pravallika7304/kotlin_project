package com.example.itemapp.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.itemapp.viewmodel.ItemViewModel

@Composable
fun ItemListScreen(navController:NavController, viewModel:ItemViewModel){

    LaunchedEffect(Unit){
        viewModel.fetchItems()
    }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)){

        Button(onClick={ navController.navigate("add") }){
            Text("Add Item")
        }

        LazyColumn{

            items(viewModel.itemList){item->

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .clickable {

                            navController.navigate(
                                "detail/${item.title}/${item.price}/${item.description}"
                            )

                        }
                ){

                    Column(modifier=Modifier.padding(16.dp)){

                        Text(item.title)
                        Text("₹${item.price}")

                    }

                }

            }

        }

    }

}
