package com.example.apptechnicaltestflock.apiservice.getlistingredients

import com.example.apptechnicaltestflock.Model.dataforingredientslist.Ingredient
import javax.inject.Inject

class ListWithIngredientsRepository @Inject constructor(private val api: ListIngredientsService){
    suspend fun getAllIngredientsFromApi(): List<Ingredient>{
        val response= api.getIngredients()
        val list= mutableListOf<Ingredient>()
        response.drinks.forEach{
            list.add(it)
        }
        return list
    }
}