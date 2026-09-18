package com.example.coffee.presentation.screens.favouritescreen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.coffee.R
import com.example.coffee.domain.model.Product
import com.example.coffee.domain.model.ui_components.MyBottomNavBar

@Composable
fun FavouritesScreen(navController: NavHostController) {
    var favouriteItems by remember {
        mutableStateOf(
            listOf(
                Product(
                    id = 1,
                    name = "意式咖啡",
                    description = "浓郁醇厚",
                    price = 3.80,
                    imageRes = R.drawable.coffee_cappuccino
                ),
                Product(
                    id = 2,
                    name = "拿铁",
                    description = "丝滑香浓",
                    price = 4.50,
                    imageRes = R.drawable.coffee_espresso
                ),
                Product(
                    id = 3,
                    name = "卡布奇诺",
                    description = "巧克力风味",
                    price = 4.20,
                    imageRes = R.drawable.coffee_flat_white
                )
            )
        )
    }
    Scaffold(
        topBar = {FavouriteScreenTopBar()},
        bottomBar = { MyBottomNavBar(navController, "Favourite") }
    ) { innerPadding ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            item {
                favouriteItems.forEach { product ->
                    FavouriteItemCard(
                        product,
                        onRemove = {favouriteItems = favouriteItems - product}
                        )
                }
            }
        }
    }
}
