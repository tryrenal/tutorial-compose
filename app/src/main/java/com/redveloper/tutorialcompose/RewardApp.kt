package com.redveloper.tutorialcompose

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.redveloper.tutorialcompose.components.BottomBar
import com.redveloper.tutorialcompose.navigation.Screen

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

private fun HomeScreen(){

}

private fun CartScreen(){

}

private fun ProfileScreen(){

}