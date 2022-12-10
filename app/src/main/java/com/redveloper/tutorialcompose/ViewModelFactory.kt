package com.redveloper.tutorialcompose

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.redveloper.tutorialcompose.data.HeroRepository

class ViewModelFactory(
    private val repository: HeroRepository
) : ViewModelProvider.NewInstanceFactory(){

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HeroViewModel::class.java)) {
            return HeroViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }
}