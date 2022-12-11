package com.redveloper.tutorialcompose.navigation

sealed class Screen(val route: String){
    object Home: Screen("home")
    object Cart: Screen("cart")
    object Profile: Screen("profile")
}
