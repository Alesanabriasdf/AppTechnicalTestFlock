package com.example.apptechnicaltestflock.apiservice.getlistcocktails

import com.example.apptechnicaltestflock.Model.dataforcocktailslist.MyInfoOfCocktails
import javax.inject.Inject

class ListWithCocktailsRepository @Inject constructor(private val api: ListCocktailsService) {
    suspend fun getAllCocktailsByIngredientFromApi(): List<MyInfoOfCocktails> {
        val response = api.getCocktails()
        val list = mutableListOf<MyInfoOfCocktails>()
        response.drinks.forEach {
            list.add(MyInfoOfCocktails(it.strDrink,it.strDrinkThumb))
        }
        return list
    }
}