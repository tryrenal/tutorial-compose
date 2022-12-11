package com.redveloper.tutorialcompose

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.redveloper.tutorialcompose.components.BottomBar

@Composable
fun RewardApp(
    modifier: Modifier = Modifier
){
    Scaffold(
        bottomBar = {
            BottomBar()
        },
        modifier = modifier
    ) { innerPadding ->

    }
}