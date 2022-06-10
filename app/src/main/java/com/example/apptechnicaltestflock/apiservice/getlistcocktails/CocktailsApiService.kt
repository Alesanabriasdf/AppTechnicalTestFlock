package com.example.apptechnicaltestflock.apiservice.getlistcocktails

import com.example.apptechnicaltestflock.Model.dataforcocktailslist.CocktailsDrinksDto
import com.example.apptechnicaltestflock.Model.dataforingredientslist.IngredientsDrinksDto
import com.example.apptechnicaltestflock.apiservice.AppConstants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface CocktailsApiService {
    @GET
    suspend fun getCocktailsByIngredient(@Url urlByIngredient:String)
    : Response<CocktailsDrinksDto>
}