package com.example.coffee.presentation.screens.cartscreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.coffee.domain.model.CartManager
import com.example.coffee.domain.model.ui_components.MyBottomNavBar
import com.example.coffee.presentation.ui.theme.LightBrown
import java.util.Locale


@Composable
fun CartScreen(navController: NavHostController) {
    val cartItems = CartManager.items
    // 空购物车时不计算配送费
    val amount = cartItems.entries.sumOf { it.key.price * it.value }
    val deliveryFee = if (cartItems.isEmpty()) 0.0 else 5.0
    val totalAmount = amount + deliveryFee
    Scaffold(
        topBar = { CartScreenTopBar() },
        bottomBar = { MyBottomNavBar(navController, "购物车") }
    ) { innerPadding ->
        if (cartItems.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "购物车是空的，快去选购吧~",
                    fontSize = 18.sp,
                    color = LightBrown
                )
            }
        } else {
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
                    cartItems.forEach { (product, quantity) ->
                        CartItemCard(
                            product = product,
                            quantity = quantity,
                            onIncrease = { CartManager.increase(product) },
                            onDecrease = { CartManager.decrease(product) }
                        )
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
                            text = String.format(Locale.US, "%.1f 元", amount),
                            style = MaterialTheme.typography.bodyMedium.copy(
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
                            text = String.format(Locale.US, "%.1f 元", deliveryFee),
                            style = MaterialTheme.typography.bodyMedium.copy(
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
}
