package com.example.coffee.domain.model.ui_components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.coffee.R
import com.example.coffee.presentation.ui.theme.LightBrown

//底部导航栏
@Preview
@Composable
fun MyBottomNavBar() {
    val navItems = listOf<NavItem>(
        NavItem("首页", R.drawable.home),
        NavItem("购物车",R.drawable.shopping_cart),
        NavItem("收藏",R.drawable.favorite),
        NavItem("我的",R.drawable.person)
    )
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.surface,  //设置底部导航栏的容器颜色
        modifier = Modifier.height(100.dp)
    ) {
        navItems.forEachIndexed {index,item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        painter = painterResource(item.icon),
                        contentDescription = item.title
                    )
                },
                label = {
                    Text(text = item.title)
                },
                modifier = Modifier.size(36.dp),
                onClick = {},
                selected = true,
                alwaysShowLabel = false,
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = LightBrown,
                    selectedTextColor = LightBrown,
                    unselectedIconColor = Color.DarkGray,
                    unselectedTextColor = Color.DarkGray,
                    indicatorColor = LightBrown.copy(0.1f)
                )
            )
        }
    }
}

data class NavItem(val title: String,val icon: Int)