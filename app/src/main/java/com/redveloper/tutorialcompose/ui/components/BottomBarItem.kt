package com.redveloper.tutorialcompose.ui.components

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.redveloper.tutorialcompose.R
import com.redveloper.tutorialcompose.model.BottomNavigationModel

@Composable
fun BottomBarItem(
    modifier: Modifier = Modifier
){
    BottomNavigation(
        modifier = modifier,
        backgroundColor = MaterialTheme.colors.background,
        contentColor = MaterialTheme.colors.primary
    ) {
        val navigationItems = listOf(
            BottomNavigationModel(
                title = stringResource(id = R.string.menu_home),
                icon = Icons.Default.Home
            ),
            BottomNavigationModel(
                title = stringResource(id = R.string.menu_favorite),
                icon = Icons.Default.Favorite
            ),
            BottomNavigationModel(
                title = stringResource(id = R.string.menu_profile),
                icon = Icons.Default.Person
            ),
        )
        navigationItems.map{
            BottomNavigationItem(
                icon = {
                    Icon(imageVector = it.icon, contentDescription = null)
                },
                label = {
                    Text(text = it.title)
                },
                selected = it.title == navigationItems[0].title,
                unselectedContentColor = Color.LightGray,
                onClick = {})
        }
    }
}