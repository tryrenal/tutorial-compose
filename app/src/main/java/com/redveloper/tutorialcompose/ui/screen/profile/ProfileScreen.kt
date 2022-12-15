package com.redveloper.tutorialcompose.ui.screen.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.redveloper.tutorialcompose.R
import com.redveloper.tutorialcompose.model.FakeBookDataSource
import com.redveloper.tutorialcompose.ui.theme.TutorialComposeTheme

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(
                vertical = 20.dp,
                horizontal = 16.dp
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(R.drawable.profile),
            contentDescription = "avatar",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape)
                .border(2.dp, Color.Gray, CircleShape)
        )
        Text(
            text = stringResource(id = R.string.name_dicoding),
            style = MaterialTheme.typography.body2
        )
        Text(
            text = stringResource(id = R.string.email_dicoding),
            style = MaterialTheme.typography.body2,
            color = Color.Gray
        )
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun PreviewProfileScreen(){
    TutorialComposeTheme {
        ProfileScreen()
    }
}