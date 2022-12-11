package com.redveloper.tutorialcompose

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.redveloper.tutorialcompose.ui.components.BottomBar
import com.redveloper.tutorialcompose.ui.navigation.Screen
import com.redveloper.tutorialcompose.ui.screen.cart.CartScreen
import com.redveloper.tutorialcompose.ui.screen.home.HomeScreen
import com.redveloper.tutorialcompose.ui.screen.profile.ProfileScreen

@Composable
fun RewardApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
){
    Scaffold(
        bottomBar = {
            BottomBar(
                navController = navController
            )
        },
        modifier = modifier
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(innerPadding)
        ){
            composable(Screen.Home.route){
                HomeScreen()
            }
            composable(Screen.Cart.route){
                CartScreen()
            }
            composable(Screen.Profile.route){
                ProfileScreen()
            }
        }
    }
}
