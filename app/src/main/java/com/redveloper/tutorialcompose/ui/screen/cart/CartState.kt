package com.redveloper.tutorialcompose.ui.screen.cart

import com.redveloper.tutorialcompose.model.OrderReward

data class CartState(
    val orderReward: List<OrderReward>,
    val totalRequiredPoint: Int
)