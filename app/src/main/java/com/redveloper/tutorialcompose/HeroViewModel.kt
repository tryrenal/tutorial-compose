package com.redveloper.tutorialcompose

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
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

    private val _query = mutableStateOf("")
    val query: State<String> get() = _query

    fun search(newQuery: String){
        _query.value = newQuery
        _groupedHeroes.value = repository.searchHeroes(_query.value)
            .sortedBy { it.name }
            .groupBy { it.name[0] }
    }
}