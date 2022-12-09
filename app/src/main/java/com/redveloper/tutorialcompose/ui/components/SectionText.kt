package com.redveloper.tutorialcompose.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.redveloper.tutorialcompose.ui.theme.TutorialComposeTheme

@Composable
fun SectionText(
    modifier: Modifier = Modifier,
    text: String
){
    Text(
        text = text,
        style = MaterialTheme.typography.h5.copy(
            fontWeight = FontWeight.Bold
        ),
        modifier = modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewSectionText(){
    TutorialComposeTheme {
        SectionText(text = "Test Section Text")
    }
}