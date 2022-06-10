package com.example.apptechnicaltestflock.apiservice.getlistingredients

import com.example.apptechnicaltestflock.Model.dataforingredientslist.IngredientsDrinksDto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class ListIngredientsService @Inject constructor(private val api: IngredientsApiService) {
    suspend fun getIngredients(): IngredientsDrinksDto {
        return withContext(Dispatchers.IO){
            val call:Response<IngredientsDrinksDto> =
                api.getIngredientsOfCocktails()
            call.body()!!
        }
    }
}