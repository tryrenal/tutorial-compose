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
import com.redveloper.tutorialcompose.ui.enum.Scale

@Composable
fun GeneralTemperatureInput(
    modifier: Modifier = Modifier,
    input: String,
    scale: Scale,
    onValueChange: (String) -> Unit
){
    Column(
        modifier = modifier
            .padding(16.dp)
    ){
        OutlinedTextField(
            value = input,
            label = {
                Text(text = stringResource(id = R.string.enter_temperature, scale.value))
            },
            onValueChange = {
                onValueChange(it)
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
    }
}