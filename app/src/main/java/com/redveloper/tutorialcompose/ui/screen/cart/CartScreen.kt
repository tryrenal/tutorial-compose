package com.redveloper.tutorialcompose.ui.screen.cart

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.redveloper.tutorialcompose.R
import com.redveloper.tutorialcompose.di.Injection
import com.redveloper.tutorialcompose.ui.ViewModelFactory
import com.redveloper.tutorialcompose.ui.common.UiState
import com.redveloper.tutorialcompose.ui.components.CartItem
import com.redveloper.tutorialcompose.ui.components.OrderButton

@Composable
fun CartScreen(
    modifier: Modifier = Modifier,
    viewModel: CartViewModel = viewModel(
        factory = ViewModelFactory(Injection.provideRepository())
    ),
    onOrderButtonClicked: (String) -> Unit
) {
    viewModel.uiState.collectAsState(initial = UiState.Loading).value.let { uiState ->
        when(uiState){
            is UiState.Loading -> {
                viewModel.getAddedOrderRewards()
            }
            is UiState.Success -> {
                CartContent(
                    state = uiState.data,
                    onProductCountChanged = { id, count ->
                        viewModel.updateOrderReward(id, count)
                    },
                    onOrderButtonClicked = onOrderButtonClicked
                )
            }
            is UiState.Error -> {

            }
        }
    }
}

@Composable
fun CartContent(
    state: CartState,
    onProductCountChanged: (id: Long, count: Int) -> Unit,
    modifier: Modifier = Modifier,
    onOrderButtonClicked: (String) -> Unit
){
    val shareMessage = stringResource(id = R.string.share_message,
        state.orderReward.count(),
        state.totalRequiredPoint)
    Column(
        modifier = modifier
    ) {
        TopAppBar(
            backgroundColor = MaterialTheme.colors.surface
        ) {
            Text(
                text = stringResource(id = R.string.menu_cart),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp),
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                textAlign = TextAlign.Center
            )
        }
        OrderButton(
            text = stringResource(id = R.string.total_order, state.totalRequiredPoint),
            enabled = state.orderReward.isNotEmpty(),
            onClick = {
                onOrderButtonClicked(shareMessage)
            },
            modifier = Modifier.padding(16.dp)
        )
        LazyColumn(
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ){
            items(state.orderReward, key = {
                it.reward.id
            }){ item ->
                CartItem(
                    rewardId = item.reward.id,
                    image = item.reward.image,
                    title = item.reward.title,
                    totalPoint = item.reward.requiredPoint * item.count,
                    count = item.count,
                    onProductCountChanged = onProductCountChanged
                )
                Divider()
            }
        }
    }
}