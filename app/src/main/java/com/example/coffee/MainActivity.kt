package com.example.coffee

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.coffee.presentation.screens.detailsscren.DetailsScreen
import com.example.coffee.presentation.screens.homescreen.HomeScreen
import com.example.coffee.presentation.ui.theme.CoffeeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CoffeeTheme {
                DetailsScreen()
            }
        }
    }
}