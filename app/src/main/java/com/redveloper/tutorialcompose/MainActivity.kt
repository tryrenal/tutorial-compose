package com.redveloper.tutorialcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.redveloper.tutorialcompose.ui.components.StatefulTemperatureInput
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
                    var input by remember {
                        mutableStateOf("")
                    }
                    var output by remember {
                        mutableStateOf("")
                    }
                    StatefulTemperatureInput(
                        input = input, output = output
                    ){ newInput ->
                        input = newInput
                        output = convertToFahrenheit(input)
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TutorialComposeTheme {
        var input by remember {
            mutableStateOf("")
        }
        var output by remember {
            mutableStateOf("")
        }
        StatefulTemperatureInput(
            input = input, output = output
        ){ newInput ->
            input = newInput
            output = convertToFahrenheit(input)
        }
    }
}

private fun convertToFahrenheit(celcius: String): String{
    return celcius.toDoubleOrNull()?.let {
        (it * 9/5) + 32
    }.toString()
}