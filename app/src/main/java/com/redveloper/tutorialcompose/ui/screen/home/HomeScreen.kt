package com.redveloper.tutorialcompose.ui.screen.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.redveloper.tutorialcompose.di.Injection
import com.redveloper.tutorialcompose.model.OrderReward
import com.redveloper.tutorialcompose.ui.ViewModelFactory
import com.redveloper.tutorialcompose.ui.common.UiState
import com.redveloper.tutorialcompose.ui.components.RewardItem

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = viewModel(factory = ViewModelFactory(Injection.provideRepository())),
    navigateToDetail: (Long) -> Unit,
) {
    viewModel.uiState.collectAsState(initial = UiState.Loading).value.let { uistate ->
        when(uistate){
            is UiState.Loading -> {
                viewModel.getAllRewards()
            }
            is UiState.Success -> {
                HomeContent(
                    orderReward = uistate.data,
                    modifier = modifier,
                    navigateToDetail = navigateToDetail
                )
            }
            is UiState.Error -> {

            }
        }
    }
}

@Composable
fun HomeContent(
    orderReward: List<OrderReward>,
    modifier: Modifier = Modifier,
    navigateToDetail: (Long) -> Unit
){
    LazyVerticalGrid(
        columns = GridCells.Adaptive(160.dp),
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier
            .testTag("RewardList"),
    ){
        items(orderReward){ item ->
            RewardItem(
                image = item.reward.image,
                title = item.reward.title,
                requiredPoint = item.reward.requiredPoint,
                modifier = Modifier
                    .clickable {
                        navigateToDetail(item.reward.id)
                    }
            )
        }
    }
}