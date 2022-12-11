package com.redveloper.tutorialcompose.components

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.redveloper.tutorialcompose.navigation.NavigationItem
import com.redveloper.tutorialcompose.R
import com.redveloper.tutorialcompose.navigation.Screen

@Composable
fun BottomBar(
    modifier: Modifier = Modifier
){
    val navigationItems = listOf(
        NavigationItem(
            title = stringResource(id = R.string.menu_home),
            icon = Icons.Default.Home,
            screen = Screen.Home
        ),
        NavigationItem(
            title = stringResource(id = R.string.menu_cart),
            icon = Icons.Default.ShoppingCart,
            screen = Screen.Home
        ),
        NavigationItem(
            title = stringResource(id = R.string.menu_profile),
            icon = Icons.Default.Person,
            screen = Screen.Home
        )
    )

    BottomNavigation(
        modifier = modifier
    ) {
        navigationItems.map { item ->
            BottomNavigationItem(
                icon = {
                       Icon(imageVector = item.icon, contentDescription = null)
                },
                selected = true,
                onClick = {},
                label = { Text(text = item.title) }
            )
        }
    }
}