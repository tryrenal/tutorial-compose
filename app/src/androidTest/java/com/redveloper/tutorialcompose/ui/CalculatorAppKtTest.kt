package com.redveloper.tutorialcompose.ui

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import com.redveloper.tutorialcompose.ui.theme.TutorialComposeTheme
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import com.redveloper.tutorialcompose.R

class CalculatorAppKtTest {
//    @get:Rule
//    val composeTestRule = createComposeRule()

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Before
    fun setUp(){
        composeTestRule.setContent {
            TutorialComposeTheme {
                CalculatorApp()
            }
        }
    }

    @Test
    fun calculate_area_of_rectangle_correct(){
        composeTestRule.onNodeWithText(
            composeTestRule.activity.getString(R.string.enter_length)
        ).performTextInput("3")
        composeTestRule.onNodeWithText(
            composeTestRule.activity.getString(R.string.enter_width)
        ).performTextInput("4")
        composeTestRule.onNodeWithText(
            composeTestRule.activity.getString(R.string.count)
        ).performClick()
        composeTestRule.onNodeWithText(
            composeTestRule.activity.getString(R.string.result, 12.0)
        ).assertExists()
    }
}