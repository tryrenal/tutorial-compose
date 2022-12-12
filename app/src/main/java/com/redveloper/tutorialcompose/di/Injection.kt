package com.redveloper.tutorialcompose.di

import android.content.Context
import com.redveloper.tutorialcompose.data.NewsRepository
import com.redveloper.tutorialcompose.data.local.room.NewsDatabase
import com.redveloper.tutorialcompose.data.remote.ApiConfig

object Injection {
    fun provideRepository(context: Context): NewsRepository {
        val apiService = ApiConfig.getApiService()
        val database = NewsDatabase.getInstance(context)
        val dao = database.newsDao()
        return NewsRepository.getInstance(apiService, dao)
    }
}