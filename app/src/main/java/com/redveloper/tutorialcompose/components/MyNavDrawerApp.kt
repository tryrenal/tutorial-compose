package com.redveloper.tutorialcompose.components

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.SnackbarResult
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import com.redveloper.tutorialcompose.R
import kotlinx.coroutines.launch

@Composable
fun MyNavDrawerApp(){
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    val context = LocalContext.current

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            MyTopBar(
                onMenuClick = {
                    scope.launch {
                        scaffoldState.drawerState.open()
                    }
                }
            )
        },
        drawerContent = {
            MyDrawerContent(
                onItemSelected = {
                    scope.launch {
                        scaffoldState.drawerState.close()
                        val snackbar = scaffoldState.snackbarHostState.showSnackbar(
                            message = context.resources.getString(R.string.coming_soon, it),
                            actionLabel = context.resources.getString(R.string.subscribe_question)
                        )
                        if(snackbar == SnackbarResult.ActionPerformed){
                            Toast.makeText(context, context.getString(R.string.subscribed_info), Toast.LENGTH_SHORT).show()
                        }
                    }
                },
                onBackPress = {
                    if (scaffoldState.drawerState.isOpen){
                        scope.launch {
                            scaffoldState.drawerState.close()
                        }
                    } else {
                        scope.launch {
                            
                        }
                    }
                }
            )
        },
        drawerGesturesEnabled = scaffoldState.drawerState.isOpen
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