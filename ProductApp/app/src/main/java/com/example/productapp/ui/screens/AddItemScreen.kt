package com.example.itemapp.ui.screens

import androidx.compose.runtime.*
import androidx.compose.material.*
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.itemapp.model.Item
import com.example.itemapp.viewmodel.ItemViewModel

@Composable
fun AddItemScreen(navController:NavController,viewModel:ItemViewModel){

    var title by remember { mutableStateOf("") }
    var price by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }

    Column(modifier=Modifier.padding(16.dp)){

        TextField(value=title,onValueChange={title=it},label={Text("Title")})

        TextField(value=price,onValueChange={price=it},label={Text("Price")})

        TextField(value=description,onValueChange={description=it},label={Text("Description")})

        Spacer(modifier=Modifier.height(16.dp))

        Button(onClick={

            if(title.isNotEmpty() && price.isNotEmpty()){

                viewModel.addItem(
                    Item(
                        id=viewModel.itemList.size+1,
                        title=title,
                        price=price.toDoubleOrNull() ?: 0.0,
                        description=description,
                        image=""
                    )
                )

                navController.popBackStack()

            }

        }){

            Text("Save")

        }

    }

}
