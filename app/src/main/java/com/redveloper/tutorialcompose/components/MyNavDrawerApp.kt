package com.redveloper.tutorialcompose.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.redveloper.tutorialcompose.R

@Composable
fun MyNavDrawerApp(){
    val appState = rememberMyNavDrawerState()
    Scaffold(
        scaffoldState = appState.scaffoldState,
        topBar = {
            MyTopBar(
                onMenuClick = {appState.onMenuClick()}
            )
        },
        drawerContent = {
            MyDrawerContent(
                onItemSelected = {
                    appState.onItemSelected(it)
                },
                onBackPress = { appState.onBackPress() }
            )
        },
        drawerGesturesEnabled = appState.scaffoldState.drawerState.isOpen
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
        ){
            Text(text = stringResource(id = R.string.hello_world))
        }
    }
}