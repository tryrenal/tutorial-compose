package com.redveloper.tutorialcompose

import androidx.lifecycle.ViewModel
import com.redveloper.tutorialcompose.data.HeroRepository
import com.redveloper.tutorialcompose.model.Hero
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class HeroViewModel(
    private val repository: HeroRepository
) : ViewModel(){

    private val _groupedHeroes = MutableStateFlow(
        repository.getHeroes()
            .sortedBy { it.name }
            .groupBy { it.name[0] }
    )

    val groupedHeroes: StateFlow<Map<Char, List<Hero>>> get() = _groupedHeroes
}