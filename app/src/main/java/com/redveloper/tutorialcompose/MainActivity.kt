package com.redveloper.tutorialcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.redveloper.tutorialcompose.model.*
import com.redveloper.tutorialcompose.ui.components.CategoryItems
import com.redveloper.tutorialcompose.ui.components.MenuItem
import com.redveloper.tutorialcompose.ui.components.SearchBar
import com.redveloper.tutorialcompose.ui.components.SectionText
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

                }
            }
        }
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun DefaultPreview() {
    TutorialComposeTheme {
        JetpackCofeeApp()
    }
}

@Composable
fun JetpackCofeeApp(){
    Column (
        modifier = Modifier.verticalScroll(rememberScrollState())
            ) {
        Banner()
        SectionText(text = stringResource(id = R.string.section_category))
        CategoryRow(categorys = dummyCategory)
        SectionText(text = stringResource(id = R.string.section_favorite_menu))
        MenuRow(menus = dummyMenu)
        SectionText(text = stringResource(id = R.string.section_best_seller_menu))
        MenuRow(menus = dummyBestSeller)
    }
}

@Composable
fun Banner(
    modifier: Modifier = Modifier
){
    Box(modifier = modifier){
        Image(
            painter = painterResource(id = R.drawable.banner),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.height(160.dp)
        )
        SearchBar()
    }
}

@Composable
fun CategoryRow(
    modifier: Modifier = Modifier,
    categorys: List<Category>
){
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ){
        items(categorys){ category ->
            CategoryItems(
                category = category,
            )
        }
    }
}

@Composable
fun MenuRow(
    modifier: Modifier = Modifier,
    menus: List<Menu>
){
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ){
        items(menus){ menu ->
            MenuItem(menu = menu)
        }
    }
}