package com.redveloper.tutorialcompose

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.redveloper.tutorialcompose.ui.components.BottomBar
import com.redveloper.tutorialcompose.ui.navigation.Screen
import com.redveloper.tutorialcompose.ui.screen.cart.CartScreen
import com.redveloper.tutorialcompose.ui.screen.detail.DetailScreen
import com.redveloper.tutorialcompose.ui.screen.home.HomeScreen
import com.redveloper.tutorialcompose.ui.screen.profile.ProfileScreen

@Composable
fun RewardApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
){

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        bottomBar = {
            if (currentRoute != Screen.DetailReward.route){
                BottomBar(
                    navController = navController
                )
            }
        },
        modifier = modifier
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(innerPadding)
        ){
            composable(Screen.Home.route){
                HomeScreen(
                    navigateToDetail = { rewardId ->
                        navController.navigate(Screen.DetailReward.createRoute(rewardId))
                    }
                )
            }
            composable(Screen.Cart.route){
                CartScreen()
            }
            composable(Screen.Profile.route){
                ProfileScreen()
            }
            composable(
                route = Screen.DetailReward.route,
                arguments = listOf(
                    navArgument("rewardId") {
                        type = NavType.LongType
                    }
                )
            ){
                val id = it.arguments?.getLong("rewardId") ?: -1L
                DetailScreen(
                    rewardId = id,
                    navigateBack = {
                        navController.navigateUp()
                    },
                    navigateToCart = {
                        navController.popBackStack()
                        navController.navigate(Screen.Cart.route){
                            popUpTo(navController.graph.findStartDestination().id){
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                )
            }
        }
    }
}
