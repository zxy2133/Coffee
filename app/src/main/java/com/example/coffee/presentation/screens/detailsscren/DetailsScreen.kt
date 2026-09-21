package com.example.coffee.presentation.screens.detailsscren

import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.coffee.R
import com.example.coffee.domain.model.Product


@Composable
fun DetailsScreen(productId: Int,navController: NavController) {
    val products = listOf(
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
        ),
        Product(
            id = 4,
            name = "摩卡",
            description = "可可风味",
            price = 4.70,
            imageRes = R.drawable.coffee_iced_mocha
        ),
        Product(
            id = 5,
            name = "玛奇朵",
            description = "醇厚奶香",
            price = 4.60,
            imageRes = R.drawable.coffee_latte
        ),
        Product(
            id = 6,
            name = "澳白",
            description = "丝绒般顺滑",
            price = 4.40,
            imageRes = R.drawable.coffee_macchiato
        ),
        Product(
            id = 7,
            name = "冰摩卡",
            description = "清爽浓郁",
            price = 4.70,
            imageRes = R.drawable.coffee_mocha
        )
    )
    val selectedProduct = products.find{it.id == productId}
    if (selectedProduct == null){
        Text(text = "未找到商品!", color = Color.Red)
        return
    }
    Scaffold(
        topBar = {DetailsScreenTopAppBar(navController, selectedProduct)},
        bottomBar = {DetailsScreenBottomAppBar(price = selectedProduct.price)}
    ){innerPadding ->
        ProductDetailContent(product = selectedProduct, innerPadding = innerPadding)
    }
}