package com.redveloper.tutorialcompose.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.redveloper.tutorialcompose.R

@Composable
fun StatefulTemperatureInput(
    input: String,
    output: String,
    modifier: Modifier = Modifier,
    onValueChange: (String) -> Unit
){
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
            onValueChange = {
                onValueChange(it)
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Text(text = stringResource(id = R.string.temperature_fahrenheit, output))
    }
}

