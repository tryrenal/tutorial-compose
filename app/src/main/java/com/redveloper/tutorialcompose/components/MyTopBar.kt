package com.redveloper.tutorialcompose.components

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.redveloper.tutorialcompose.R

@Composable
fun MyTopBar(
    modifier: Modifier = Modifier,
    onMenuClick: () -> Unit
){
    TopAppBar(
        navigationIcon = {
            IconButton(
                onClick = {
                    onMenuClick()
                }
            ) {
                Icon(imageVector = Icons.Default.Menu, contentDescription = null)
            }
        },
        title = {
            Text(text = stringResource(id = R.string.app_name))
        }
    )
}