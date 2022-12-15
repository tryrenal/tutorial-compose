package com.redveloper.tutorialcompose.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.redveloper.tutorialcompose.ui.components.BottomBar
import com.redveloper.tutorialcompose.ui.navigation.Screen
import com.redveloper.tutorialcompose.ui.screen.detail.DetailScreen
import com.redveloper.tutorialcompose.ui.screen.home.HomeScreen
import com.redveloper.tutorialcompose.ui.screen.profile.ProfileScreen

@Composable
fun RedveloperApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
){
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        bottomBar = {
            if (currentRoute != Screen.DetailHome.route){
                BottomBar(navController = navController)
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
                    navigateToDetail = { bookId ->
                        navController.navigate(Screen.DetailHome.createRoute(bookId))
                    }
                )
            }
            composable(Screen.Profile.route){
                ProfileScreen()
            }
            composable(
                Screen.DetailHome.route,
                arguments = listOf(
                    navArgument("bookId"){
                        type = NavType.LongType
                    }
                )
            ){
                val id = it.arguments?.getLong("bookId") ?: -1L
                DetailScreen(bookId = id){
                    navController.navigateUp()
                }
            }
        }

    }
}