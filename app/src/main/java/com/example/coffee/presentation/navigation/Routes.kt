package com.example.coffee.presentation.navigation

import kotlinx.serialization.Serializable

sealed class Routes {

    @Serializable
    object WelcomeScreen : Routes()

    @Serializable
    object HomeScreen : Routes()

    @Serializable
    data class DetailScreen(val productID: Int) : Routes()

    @Serializable
    object CartScreen : Routes()

    @Serializable
    object PersonalScreen : Routes()

    @Serializable
    object FavouritesScreen : Routes()
}