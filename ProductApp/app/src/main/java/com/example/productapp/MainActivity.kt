
package com.example.itemapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.itemapp.navigation.NavGraph
import com.example.itemapp.viewmodel.ItemViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel = ItemViewModel(this)

        setContent {
            NavGraph(viewModel)
        }
    }
}
