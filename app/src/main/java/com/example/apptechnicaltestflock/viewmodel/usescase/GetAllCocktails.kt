package com.example.apptechnicaltestflock.viewmodel.usescase

import com.example.apptechnicaltestflock.Model.dataforcocktailslist.MyInfoOfCocktails
import com.example.apptechnicaltestflock.apiservice.getlistcocktails.ListWithCocktailsRepository
import javax.inject.Inject

class GetAllCocktails @Inject constructor(private val repository: ListWithCocktailsRepository) {

    suspend operator fun invoke(): List<MyInfoOfCocktails> {
        return repository.getAllCocktailsByIngredientFromApi()
    }
}