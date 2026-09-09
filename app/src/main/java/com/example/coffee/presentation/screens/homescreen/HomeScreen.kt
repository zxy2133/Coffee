package com.example.coffee.presentation.screens.homescreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon

import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coffee.R
import com.example.coffee.domain.model.Product
import com.example.coffee.domain.model.ui_components.MyBottomNavBar

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreen() {
    val location = "张学源"
    Scaffold(
        bottomBar = { MyBottomNavBar() }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(1f / 3f)
                .background(
                    //brush用于实现渐变效果，linearGradient()线性渐变，需要传入一个颜色列表
                    brush = Brush.linearGradient(
                        colors = listOf(
                            Color(0xFF303030),
                            Color(0xFF1F1F1F),
                            Color(0xFF121212)
                        )
                    )
                )
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .padding(innerPadding),

            ) {
            //商品数据
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
            ProductsGrid(products = products) {
                Text(text = "首页", fontSize = 16.sp, color = Color.Gray)
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = location,
                        color = Color.White,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Icon(
                        painter = painterResource(R.drawable.arrow_down),
                        contentDescription = "改变位置",
                        tint = Color.White
                    )
                }
                Spacer(modifier = Modifier.height(30.dp))
                SearchBar()
                Spacer(modifier = Modifier.height(24.dp))
                Image(
                    painter = painterResource(R.drawable.banner_1),
                    contentDescription = "Home Banner",
                    modifier = Modifier.clip(shape = RoundedCornerShape(16.dp)),
                    alignment = Alignment.Center,
                    contentScale = ContentScale.Fit
                )
                Spacer(modifier = Modifier.height(16.dp))
                CoffeeCategoryFilterRow()

            }
        }

    }
}