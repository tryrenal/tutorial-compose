package com.redveloper.tutorialcompose.di

import com.redveloper.tutorialcompose.data.BookRepository

object Injection {
    fun provideRepository(): BookRepository{
        return BookRepository.getInstance()
    }
}