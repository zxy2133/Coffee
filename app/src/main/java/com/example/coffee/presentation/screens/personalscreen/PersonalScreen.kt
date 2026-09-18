package com.example.coffee.presentation.screens.personalscreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.coffee.domain.model.ui_components.MyBottomNavBar

@Composable
fun PersonalScreen(navController: NavHostController) {
    Scaffold(
        bottomBar = { MyBottomNavBar(navController, "Personal") }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "我的", fontSize = 24.sp)
        }
    }
}
