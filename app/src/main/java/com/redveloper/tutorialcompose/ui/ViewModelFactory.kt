package com.redveloper.tutorialcompose.ui

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.redveloper.tutorialcompose.data.NewsRepository
import com.redveloper.tutorialcompose.di.Injection
import com.redveloper.tutorialcompose.ui.detail.NewsDetailViewModel
import com.redveloper.tutorialcompose.ui.list.NewsViewModel

class ViewModelFactory private constructor(private val newsRepository: NewsRepository) :
    ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NewsViewModel::class.java)) {
            return NewsViewModel(newsRepository) as T
        } else if (modelClass.isAssignableFrom(NewsDetailViewModel::class.java)) {
            return NewsDetailViewModel(newsRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null
        fun getInstance(context: Context): ViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: ViewModelFactory(Injection.provideRepository(context))
            }.also { instance = it }
    }
}