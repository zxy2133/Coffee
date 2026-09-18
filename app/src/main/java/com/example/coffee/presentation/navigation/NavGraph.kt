package com.example.coffee.presentation.navigation

import androidx.compose.runtime.Composable
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
}