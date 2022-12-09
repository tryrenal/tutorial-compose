package com.redveloper.tutorialcompose.model

import com.redveloper.tutorialcompose.R

data class Menu(
    val image: Int,
    val title: String,
    val price: String
)

val dummyMenu = listOf(
    Menu(R.drawable.menu1, "Tiramisu Coffee", "Rp 28.000"),
    Menu(R.drawable.menu2, "Kocok Coffee", "Rp 23.000"),
    Menu(R.drawable.menu3, "Latte Coffee", "Rp 22.000"),
    Menu(R.drawable.menu4, "Coffaa Coffee", "Rp 58.000"),
)

val dummyBestSeller = dummyMenu.shuffled()
