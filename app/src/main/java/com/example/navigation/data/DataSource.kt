package com.example.navigation.data

import com.example.navigation.R
import com.example.navigation.model.Vocabulary

class DataSource {
    fun loadVocabulary(): List<Vocabulary> {
        return listOf(
            Vocabulary("Car", R.drawable.car, R.raw.car),
            Vocabulary("Home", R.drawable.home, R.raw.home),
            Vocabulary("Bag", R.drawable.bag, R.raw.bag)
        )
    }
}