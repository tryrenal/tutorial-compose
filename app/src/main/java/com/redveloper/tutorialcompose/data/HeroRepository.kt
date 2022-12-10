package com.redveloper.tutorialcompose.data

import com.redveloper.tutorialcompose.model.Hero
import com.redveloper.tutorialcompose.model.HerosData

class HeroRepository {
    fun getHeroes(): List<Hero>{
        return HerosData.heroes
    }
}