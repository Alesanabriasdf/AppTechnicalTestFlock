package com.example.apptechnicaltestflock.viewmodel.usescase

import com.example.apptechnicaltestflock.Model.dataforingredientslist.Ingredient
import com.example.apptechnicaltestflock.apiservice.getlistingredients.ListWithIngredientsRepository
import javax.inject.Inject

class GetAllIngredients @Inject constructor(private val repository: ListWithIngredientsRepository) {

    suspend operator fun invoke (): List<Ingredient>{
        return repository.getAllIngredientsFromApi()
    }
}