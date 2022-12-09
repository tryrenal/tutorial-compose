package com.redveloper.tutorialcompose.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.redveloper.tutorialcompose.R
import com.redveloper.tutorialcompose.model.Category
import com.redveloper.tutorialcompose.ui.theme.TutorialComposeTheme

@Composable
fun CategoryItems(
    modifier: Modifier = Modifier,
    category: Category
){
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = category.image),
            contentDescription = null,
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape)
        )
        Text(
            text = stringResource(id = category.category),
            fontSize = 10.sp,
            modifier = Modifier
                .paddingFromBaseline(top = 16.dp, bottom = 8.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCategoryItems(){
    TutorialComposeTheme {
        CategoryItems(
            category = Category(image = R.drawable.icon_category_latte, category = R.string.category_latte),
            modifier = Modifier.padding(8.dp)
        )
    }
}