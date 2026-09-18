package com.example.coffee.presentation.screens.cartscreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.coffee.R
import com.example.coffee.domain.model.Product
import com.example.coffee.domain.model.ui_components.MyBottomNavBar
import com.example.coffee.presentation.ui.theme.LightBrown


@Composable
fun CartScreen(navController: NavHostController) {
    var amount by remember { mutableDoubleStateOf(0.0) }
    var deliveryFee by remember { mutableDoubleStateOf(0.0) }
    var totalAmount by remember { mutableDoubleStateOf(0.0) }
    val cartProducts = listOf(
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
    Scaffold(
        topBar = { CartScreenTopBar() },
        bottomBar = { MyBottomNavBar(navController, "Cart") }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(16.dp)
                .padding(innerPadding)
        ) {
            item {
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "商品清单",
                        fontSize = 30.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = LightBrown
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                cartProducts.forEach { product ->
                    CartItemCard(product)
                }
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "价格清单", style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.Bold
                    )
                )
                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "总价", style = MaterialTheme.typography.bodyMedium.copy(
                            fontWeight = FontWeight.SemiBold
                        )
                    )
                    Text(
                        text = "$amount 元", style = MaterialTheme.typography.bodyMedium.copy(
                            fontWeight = FontWeight.SemiBold
                        )
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "配送费", style = MaterialTheme.typography.bodyMedium.copy(
                            fontWeight = FontWeight.SemiBold
                        )
                    )
                    Text(
                        text = "$deliveryFee 元", style = MaterialTheme.typography.bodyMedium.copy(
                            fontWeight = FontWeight.SemiBold
                        )
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                PaymentModeSelectionCard(totalAmount)
            }
        }
    }
}