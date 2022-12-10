package com.redveloper.tutorialcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.redveloper.tutorialcompose.ui.components.GeneralTemperatureInput
import com.redveloper.tutorialcompose.ui.components.StatefulTemperatureInput
import com.redveloper.tutorialcompose.ui.enum.Scale
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
                    Column {
                        StatefulTemperatureInput(
                            input = input, output = output
                        ){ newInput ->
                            input = newInput
                            output = convertToFahrenheit(input)
                        }
                        TwoWayConverterApp(
                            modifier = Modifier.padding(top = 10.dp)
                        )
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

@Composable
fun TwoWayConverterApp(
    modifier: Modifier = Modifier
){
    var celcius by remember {
        mutableStateOf("")
    }
    var fahrenheit by remember {
        mutableStateOf("")
    }
    Column(
        modifier = modifier
    ) {
        Text(
            text = stringResource(id = R.string.two_way_converter),
            style = MaterialTheme.typography.h5
        )
        GeneralTemperatureInput(
            input = celcius,
            scale = Scale.CELCIUS,
            onValueChange = { newInput ->
                celcius = newInput
                fahrenheit = convertToFahrenheit(celcius)
            }
        )
        Spacer(modifier = Modifier.size(10.dp))
        GeneralTemperatureInput(
            input = fahrenheit,
            scale = Scale.FAHRENHEIT,
            onValueChange = { newInput ->
                fahrenheit = newInput
                celcius = convertToCelcius(fahrenheit)
            }
        )
    }
}

private fun convertToFahrenheit(celcius: String): String{
    return celcius.toDoubleOrNull()?.let {
        (it * 9/5) + 32
    }.toString()
}

private fun convertToCelcius(fahrenheit: String): String {
    return fahrenheit.toDoubleOrNull()?.let {
        (it - 32) * 5 / 9
    }.toString()
}