package com.redveloper.tutorialcompose.ui.list

import androidx.lifecycle.ViewModel
import com.redveloper.tutorialcompose.data.NewsRepository

class NewsViewModel(private val newsRepository: NewsRepository) : ViewModel() {
    fun getHeadlineNews() = newsRepository.getHeadlineNews()

    fun getBookmarkedNews() = newsRepository.getBookmarkedNews()
}