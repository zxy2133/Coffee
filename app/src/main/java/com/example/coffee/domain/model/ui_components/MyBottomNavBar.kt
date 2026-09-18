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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.coffee.R
import com.example.coffee.presentation.navigation.Routes
import com.example.coffee.presentation.ui.theme.LightBrown

//底部导航栏
@Composable
fun MyBottomNavBar(navController: NavHostController, route: String) {
    val navItems = listOf(
        NavItem("Home", R.drawable.home, Routes.HomeScreen),
        NavItem("Cart", R.drawable.shopping_cart, Routes.CartScreen),
        NavItem("Favourite", R.drawable.favorite, Routes.FavouritesScreen),
        NavItem("Personal", R.drawable.person, Routes.PersonalScreen)
    )
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.surface,  //设置底部导航栏的容器颜色
        modifier = Modifier.height(100.dp)
    ) {
        navItems.forEachIndexed { index, item ->
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
                onClick = {
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true    //保存页面状态
                        }
                        launchSingleTop = true   //复用栈顶项，防止重复创建
                        restoreState = true //恢复页面状态
                    }
                },
                selected = item.title == route,
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

data class NavItem(val title: String, val icon: Int, val route: Routes)