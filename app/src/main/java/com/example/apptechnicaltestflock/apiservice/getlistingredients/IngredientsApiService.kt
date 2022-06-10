package com.example.apptechnicaltestflock.apiservice.getlistingredients

import com.example.apptechnicaltestflock.Model.dataforingredientslist.IngredientsDrinksDto
import com.example.apptechnicaltestflock.apiservice.AppConstants
import retrofit2.Response
import retrofit2.http.GET

interface IngredientsApiService {
    @GET(AppConstants.LIST_END_POINT)
    suspend fun getIngredientsOfCocktails() : Response<IngredientsDrinksDto>
}