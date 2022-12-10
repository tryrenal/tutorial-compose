package com.redveloper.tutorialcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.OnBackPressedCallback
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.tooling.preview.Preview
import com.redveloper.tutorialcompose.components.MyNavDrawerApp
import com.redveloper.tutorialcompose.ui.theme.TutorialComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TutorialComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MyNavDrawerApp()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TutorialComposeTheme {
        MyNavDrawerApp()
    }
}

@Composable
fun BackPressHandler(
    enabled: Boolean = true,
    onBackPressed: () -> Unit
){
    val currentOnBackPressed by rememberUpdatedState(newValue = onBackPressed)
    val backCallback = remember {
        object : OnBackPressedCallback(enabled) {
            override fun handleOnBackPressed() {
                currentOnBackPressed()
            }
        }
    }

    SideEffect {
        backCallback.isEnabled = enabled
    }

    val backDispatcher = checkNotNull(LocalOnBackPressedDispatcherOwner.current){
        "No OnBackPressed"
    }.onBackPressedDispatcher

    val lifecycleOwner = LocalLifecycleOwner.current
    DisposableEffect(lifecycleOwner, backDispatcher){
        backDispatcher.addCallback(lifecycleOwner, backCallback)
        onDispose {
            backCallback.remove()
        }
    }
}