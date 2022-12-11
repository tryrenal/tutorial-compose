package com.redveloper.tutorialcompose.ui.screen.cart

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.redveloper.tutorialcompose.data.RewardRepository
import com.redveloper.tutorialcompose.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CartViewModel(
    private val repository: RewardRepository
) : ViewModel() {
    private val _uiState: MutableStateFlow<UiState<CartState>> = MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<CartState>>
        get() = _uiState

    fun getAddedOrderRewards() {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            repository.getAddedOrderRewards()
                .collect { orderReward ->
                    val totalRequiredPoint =
                        orderReward.sumOf { it.reward.requiredPoint * it.count }
                    _uiState.value = UiState.Success(CartState(orderReward, totalRequiredPoint))
                }
        }
    }

    fun updateOrderReward(rewardId: Long, count: Int) {
        viewModelScope.launch {
            repository.updateOrderReward(rewardId, count)
                .collect { isUpdated ->
                    if (isUpdated) {
                        getAddedOrderRewards()
                    }
                }
        }
    }
}