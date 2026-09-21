package com.example.coffee.presentation.navigation

import android.app.Activity
import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.coffee.presentation.screens.cartscreen.CartScreen
import com.example.coffee.presentation.screens.detailsscren.DetailsScreen
import com.example.coffee.presentation.screens.favouritescreen.FavouritesScreen
import com.example.coffee.presentation.screens.homescreen.HomeScreen
import com.example.coffee.presentation.screens.personalscreen.PersonalScreen
import com.example.coffee.presentation.screens.welcomescreen.WelcomeScreen

@Composable
fun NavGraph() {
    val navController = rememberNavController()
    val context = LocalContext.current
    var backPressedTime by remember { mutableLongStateOf(0L) }

    // 监听当前目的地，判断是否处于首页
    val currentEntry by navController.currentBackStackEntryFlow
        .collectAsState(initial = navController.currentBackStackEntry)
    val onHome = currentEntry?.destination?.route == Routes.HomeScreen::class.qualifiedName

    NavHost(navController = navController, startDestination = Routes.WelcomeScreen){
        composable <Routes.WelcomeScreen>{
            WelcomeScreen(navController)
        }
        composable<Routes.HomeScreen>{
            HomeScreen(navController)
        }
        composable <Routes.DetailScreen>{backStackEntry ->
            val args = backStackEntry.toRoute<Routes.DetailScreen>()
            DetailsScreen(productId = args.productID,navController)
        }
        composable<Routes.CartScreen> {
            CartScreen(navController)
        }
        composable<Routes.FavouritesScreen> {
            FavouritesScreen(navController)
        }
        composable<Routes.PersonalScreen> {
            PersonalScreen(navController)
        }
    }

    // 返回键逻辑：非首页时直接回首页（清栈）；首页时 2 秒内连按两次退出应用
    // 放在 NavHost 之后注册，优先级高于 NavHost 默认的逐层 pop
    BackHandler {
        if (onHome) {
            val now = System.currentTimeMillis()
            if (now - backPressedTime < 2000) {
                (context as? Activity)?.finish()
            } else {
                Toast.makeText(context, "再按一次返回键退出应用", Toast.LENGTH_SHORT).show()
                backPressedTime = now
            }
        } else {
            navController.navigate(Routes.HomeScreen) {
                popUpTo(navController.graph.startDestinationId) {
                    inclusive = true
                }
                launchSingleTop = true
            }
        }
    }
}
