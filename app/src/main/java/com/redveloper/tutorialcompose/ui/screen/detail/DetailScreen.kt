package com.redveloper.tutorialcompose.ui.screen.detail

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.redveloper.tutorialcompose.R
import com.redveloper.tutorialcompose.di.Injection
import com.redveloper.tutorialcompose.model.FakeBookDataSource
import com.redveloper.tutorialcompose.ui.ViewModelFactory
import com.redveloper.tutorialcompose.ui.common.UiState
import com.redveloper.tutorialcompose.ui.theme.TutorialComposeTheme

@Composable
fun DetailScreen(
    bookId: Long,
    viewModel: DetailViewModel = viewModel(factory = ViewModelFactory(Injection.provideRepository())),
    navigateBack: () -> Unit
){
    viewModel.uiState.collectAsState(initial = UiState.Loading).value.let { uiState ->
        when(uiState){
            is UiState.Loading -> {
                viewModel.getBookById(bookId)
            }
            is UiState.Error -> {

            }
            is UiState.Success -> {
                val data = uiState.data
                DetailContent(
                    image = data.image,
                    title = stringResource(id = data.title),
                    author = stringResource(id = data.author),
                    description = stringResource(id = data.description),
                    navigateBack = navigateBack
                )
            }
        }
    }
}

@Composable
fun DetailContent(
    modifier: Modifier = Modifier,
    @DrawableRes image: Int,
    title: String,
    author: String,
    description: String,
    navigateBack: () -> Unit
){
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Back"
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = { navigateBack() }
                    ) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
                    }
                },
                backgroundColor = MaterialTheme.colors.primary
            )
        },
    ) {
        Column (
            modifier = modifier
                .fillMaxWidth()
                .padding(
                    vertical = 20.dp,
                    horizontal = 16.dp
                )
        ){
            Row{
                Image(
                    painter = painterResource(id = image),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .height(100.dp)
                        .clip(RoundedCornerShape(8.dp))
                )
                Column (
                    modifier = Modifier
                        .padding(start = 8.dp)
                ){
                    Text(
                        text = title,
                        style = MaterialTheme.typography.h5
                    )
                    Text(
                        text = stringResource(id = R.string.label_author, author),
                        style = MaterialTheme.typography.caption
                    )
                }
            }
            OutlinedButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = Color.Blue
                ),
                onClick = {

                },
                content = {
                    Text(
                        text = stringResource(id = R.string.free_sample)
                    )
                }
            )
            Text(
                text =  description,
                style = MaterialTheme.typography.body2,
                modifier = Modifier
                    .padding(top = 10.dp)
            )
        }
    }

}

@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun PreviewDetailContent(){
    TutorialComposeTheme {
        DetailContent(
            image = R.drawable.book_1,
            title = "Book 1",
            author = "Renaldy",
            description = FakeBookDataSource._dummyDesc
        ){

        }
    }
}