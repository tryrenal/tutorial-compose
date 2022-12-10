package com.redveloper.tutorialcompose.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.redveloper.tutorialcompose.BackPressHandler
import com.redveloper.tutorialcompose.R
import com.redveloper.tutorialcompose.model.DrawerModel

@Composable
fun MyDrawerContent(
    modifier: Modifier = Modifier,
    onItemSelected: (title: String) -> Unit,
    onBackPress: () -> Unit
){
    val items = listOf(
        DrawerModel(
            title = stringResource(id = R.string.home),
            icon = Icons.Default.Home
        ),
        DrawerModel(
            title = stringResource(id = R.string.favourite),
            icon = Icons.Default.Favorite
        ),
        DrawerModel(
            title = stringResource(id = R.string.profile),
            icon = Icons.Default.Person
        )
    )

    Column(modifier = modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .height(190.dp)
                .fillMaxWidth()
                .background(MaterialTheme.colors.primary)
        )
        for (item in items){
            Row (
                modifier = Modifier
                    .clickable { onItemSelected.invoke(item.title) }
                    .padding(vertical = 12.dp, horizontal = 16.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ){
                Icon(
                    imageVector = item.icon,
                    contentDescription = null,
                    tint = Color.DarkGray
                )
                Spacer(modifier = Modifier.width(32.dp))
                Text(text = item.title, style = MaterialTheme.typography.subtitle2)
            }
        }
        Divider()
    }
    BackPressHandler {
        onBackPress()
    }
}