package com.example.itemapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.*
import com.example.itemapp.ui.screens.*
import com.example.itemapp.viewmodel.ItemViewModel

@Composable
fun NavGraph(viewModel:ItemViewModel){

    val navController = rememberNavController()

    NavHost(navController,startDestination="list"){

        composable("list"){
            ItemListScreen(navController,viewModel)
        }

        composable("add"){
            AddItemScreen(navController,viewModel)
        }

        composable("detail/{title}/{price}/{description}"){

            ItemDetailScreen(
                title = it.arguments?.getString("title") ?: "",
                price = it.arguments?.getString("price") ?: "",
                description = it.arguments?.getString("description") ?: ""
            )
        }
    }
}
