package com.redveloper.tutorialcompose.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.redveloper.tutorialcompose.R
import com.redveloper.tutorialcompose.ui.theme.TutorialComposeTheme

@Composable
fun StatefulTemperatureInput(
    modifier: Modifier = Modifier
){
    var input  by remember {
        mutableStateOf("")
    }
    var output by remember {
        mutableStateOf("")
    }
    Column(
        modifier = modifier
            .padding(16.dp)
    ){
        Text(text = stringResource(id = R.string.stateful_converter),
            style = MaterialTheme.typography.h5)
        OutlinedTextField(
            value = input,
            label = {
                Text(text = stringResource(id = R.string.enter_celsius))
            },
            onValueChange = { newInput ->
                input = newInput
                output = convertToFahrenheit(input)
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Text(text = stringResource(id = R.string.temperature_fahrenheit, output))
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewStatefulTemperatureInput(){
    TutorialComposeTheme {
        StatefulTemperatureInput()
    }
}

private fun convertToFahrenheit(celcius: String): String{
    return celcius.toDoubleOrNull()?.let {
        (it * 9/5) + 32
    }.toString()
}