package com.redveloper.tutorialcompose.ui.screen.detail

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.redveloper.tutorialcompose.model.OrderReward
import com.redveloper.tutorialcompose.model.Reward
import org.junit.Rule
import com.redveloper.tutorialcompose.R
import com.redveloper.tutorialcompose.onNodeWithStringId
import com.redveloper.tutorialcompose.ui.theme.TutorialComposeTheme
import org.junit.Before
import org.junit.Test

class DetailScreenKtTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    private val fakeOrderReward = OrderReward(
        reward = Reward(
            4, R.drawable.reward_4, "Jaket Renaldy", 7500,
        ),
        count = 0
    )

    @Before
    fun setup(){
        composeTestRule.setContent {
            TutorialComposeTheme() {
                DetailContent(
                    image = fakeOrderReward.reward.image,
                    title = fakeOrderReward.reward.title,
                    basePoint = fakeOrderReward.reward.requiredPoint,
                    count = fakeOrderReward.count,
                    onBackClick = {

                    },
                    onAddToCart = {

                    }
                )
            }
        }
        composeTestRule.onRoot().printToLog("currentLabelExist")
    }

    @Test
    fun detailContent_isDisplayed(){
        composeTestRule.onNodeWithText(
            fakeOrderReward.reward.title
        ).assertIsDisplayed()
        composeTestRule.onNodeWithText(
            composeTestRule.activity.getString(
                R.string.required_point,
                fakeOrderReward.reward.requiredPoint
            )
        ).assertIsDisplayed()
    }

    @Test
    fun increaseProduct_buttonEnabled(){
        composeTestRule.onNodeWithContentDescription("Order Button")
            .assertIsNotEnabled()
        composeTestRule.onNodeWithStringId(R.string.plus_symbol).performClick()
        composeTestRule.onNodeWithContentDescription("Order Button")
            .assertIsEnabled()
    }

    @Test
    fun increaseProduct_correctCounter(){
        composeTestRule.onNodeWithStringId(R.string.plus_symbol)
            .performClick()
            .performClick()
        composeTestRule.onNodeWithTag("count").assert(hasText("2"))
    }
}