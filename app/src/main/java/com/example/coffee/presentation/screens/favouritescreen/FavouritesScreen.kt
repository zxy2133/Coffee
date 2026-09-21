package com.example.coffee.presentation.screens.favouritescreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.coffee.domain.model.FavouriteManager
import com.example.coffee.domain.model.ui_components.MyBottomNavBar
import com.example.coffee.presentation.ui.theme.LightBrown

@Composable
fun FavouritesScreen(navController: NavHostController) {
    val favouriteItems = FavouriteManager.items
    Scaffold(
        topBar = {FavouriteScreenTopBar()},
        bottomBar = { MyBottomNavBar(navController, "收藏夹") }
    ) { innerPadding ->
        if (favouriteItems.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "收藏夹是空的，快去收藏吧~",
                    fontSize = 18.sp,
                    color = LightBrown
                )
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                item {
                    favouriteItems.forEach { product ->
                        FavouriteItemCard(
                            product,
                            onRemove = { FavouriteManager.remove(product) }
                        )
                    }
                }
            }
        }
    }
}
