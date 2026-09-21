package com.example.coffee.presentation.screens.personalscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.coffee.R
import com.example.coffee.domain.model.ui_components.MyBottomNavBar
import com.example.coffee.presentation.navigation.Routes
import com.example.coffee.presentation.ui.theme.LightBrown

@Composable
fun PersonalScreen(navController: NavHostController) {
    Scaffold(
        bottomBar = { MyBottomNavBar(navController, "我的") }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .padding(innerPadding)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .size(120.dp)
                        .clip(shape = CircleShape)
                        .background(color = LightBrown.copy(0.15f)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(R.drawable.person),
                        contentDescription = "我的头像",
                        modifier = Modifier.size(80.dp),
                        tint = LightBrown
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "张学源",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = "18177560993@163.com",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.DarkGray
                )
            }
            Spacer(modifier = Modifier.height(50.dp))
            Text(
                text = "地址",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "广东省深圳市",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.DarkGray
            )
            Spacer(modifier = Modifier.height(50.dp))
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = Color.LightGray.copy(0.5f))
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(4.dp)
                            .clickable {
                                navController.navigate(Routes.CartScreen) {
                                    // 弹出到首页，保持与底部导航一致的栈结构
                                    popUpTo(Routes.HomeScreen) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            },
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.shopping_cart),
                            contentDescription = "购物车",
                            tint = LightBrown,
                            modifier = Modifier
                                .padding(8.dp)
                                .size(28.dp)
                        )
                        Spacer(modifier = Modifier.width(16.dp))
                        Text(text = "购物车", fontSize = 20.sp)
                    }
                    HorizontalDivider(
                        modifier = Modifier.fillMaxWidth(),
                        thickness = 3.dp,
                        color = LightBrown
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(4.dp)
                            .clickable {
                                navController.navigate(Routes.FavouritesScreen) {
                                    // 弹出到首页，保持与底部导航一致的栈结构
                                    popUpTo(Routes.HomeScreen) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            },
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.favorite),
                            contentDescription = "收藏夹",
                            tint = LightBrown,
                            modifier = Modifier
                                .padding(8.dp)
                                .size(28.dp)
                        )
                        Spacer(modifier = Modifier.width(16.dp))
                        Text(text = "收藏夹", fontSize = 20.sp)
                    }
                }
            }
        }
    }
}
