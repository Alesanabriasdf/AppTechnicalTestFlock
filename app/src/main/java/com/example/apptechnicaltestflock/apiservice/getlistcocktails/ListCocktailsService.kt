package com.example.apptechnicaltestflock.apiservice.getlistcocktails

import com.example.apptechnicaltestflock.Model.dataforcocktailslist.CocktailsDrinksDto
import com.example.apptechnicaltestflock.view.MainActivity.Companion.arg
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class ListCocktailsService @Inject constructor(private val api: CocktailsApiService){

    suspend fun getCocktails(): CocktailsDrinksDto {
        return withContext(Dispatchers.IO){
            val ingredient=arg.getId()
            val call: Response<CocktailsDrinksDto> =
                api.getCocktailsByIngredient("/api/json/v1/1/filter.php?i=$ingredient")
            call.body()!!
        }
    }
}