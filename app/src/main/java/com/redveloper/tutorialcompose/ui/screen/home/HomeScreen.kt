package com.redveloper.tutorialcompose.ui.screen.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.redveloper.tutorialcompose.di.Injection
import com.redveloper.tutorialcompose.model.BookModel
import com.redveloper.tutorialcompose.ui.ViewModelFactory
import com.redveloper.tutorialcompose.ui.common.UiState
import com.redveloper.tutorialcompose.ui.components.BookCardItem
import com.redveloper.tutorialcompose.ui.theme.TutorialComposeTheme


@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = viewModel(factory = ViewModelFactory(Injection.provideRepository())),
    navigateToDetail: (Long) -> Unit
){
    viewModel.uiState.collectAsState(initial = UiState.Loading).value.let { uistate ->
        when(uistate){
            is UiState.Loading -> {
                viewModel.getListBook()
            }
            is UiState.Error -> {

            }
            is UiState.Success -> {
                HomeContent(
                    listBook = uistate.data,
                    modifier = modifier,
                    navigateToDetail = navigateToDetail
                )
            }
        }
    }
}

@Composable
fun HomeContent(
    modifier: Modifier = Modifier,
    listBook: List<BookModel>,
    navigateToDetail: (Long) -> Unit
){
    LazyColumn(
        verticalArrangement = Arrangement.SpaceBetween
    ){
        items(listBook){ item ->
            BookCardItem(
                title = item.title,
                image = item.image,
                description = item.description,
                modifier = modifier
                    .fillMaxWidth()
                    .padding(horizontal = 5.dp, vertical = 10.dp)
                    .clickable {
                        navigateToDetail(item.id)
                    }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHomeScreen(){
    TutorialComposeTheme {
        HomeScreen(
            navigateToDetail = {

            }
        )
    }
}