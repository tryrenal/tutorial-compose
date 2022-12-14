package com.redveloper.tutorialcompose.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.redveloper.tutorialcompose.ui.theme.Shapes
import com.redveloper.tutorialcompose.R
import com.redveloper.tutorialcompose.model.FakeBookDataSource
import com.redveloper.tutorialcompose.ui.theme.TutorialComposeTheme

@Composable
fun BookCardItem(
    title: String,
    image: Int,
    description: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
    ){
        Image(
            painter = painterResource(id = image),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(90.dp)
                .clip(Shapes.small)
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1.0f)
                .padding(10.dp)
        ) {
            Text(
                text = title,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.subtitle1.copy(
                    fontWeight = FontWeight.ExtraBold
                )
            )
            Text(
                text = description,
                overflow = TextOverflow.Ellipsis,
                color = Color.LightGray,
                style = MaterialTheme.typography.subtitle2,
                maxLines = 2
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewBookCardItem(){
    TutorialComposeTheme {
        BookCardItem(title = "Buku nomor 1", image = R.drawable.book_1, description = FakeBookDataSource._dummyDesc)
    }
}