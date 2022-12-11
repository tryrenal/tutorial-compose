package com.redveloper.tutorialcompose.di

import com.redveloper.tutorialcompose.data.RewardRepository


object Injection {
    fun provideRepository(): RewardRepository {
        return RewardRepository.getInstance()
    }
}