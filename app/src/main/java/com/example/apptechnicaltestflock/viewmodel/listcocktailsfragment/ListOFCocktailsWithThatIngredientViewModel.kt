package com.example.apptechnicaltestflock.viewmodel.listcocktailsfragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apptechnicaltestflock.Model.dataforcocktailslist.MyInfoOfCocktails
import com.example.apptechnicaltestflock.Model.dataforingredientslist.Ingredient
import com.example.apptechnicaltestflock.viewmodel.usescase.GetAllCocktails
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListOFCocktailsWithThatIngredientViewModel @Inject constructor(private val getAllCocktails: GetAllCocktails) :
    ViewModel(){

    var listOfAllCocktails = MutableLiveData<List<MyInfoOfCocktails>>()

    val loading = MutableLiveData<Boolean>()

    val showError = MutableLiveData<Boolean>()

    fun onGetAllCocktails() {
        viewModelScope.launch {
            loading.postValue(true)
            try {
                val listOfCocktailsWithThatIngredient = getAllCocktails()
                listOfAllCocktails.value = listOfCocktailsWithThatIngredient
                loading.postValue(false)
            } catch (e: Exception) {
                loading.postValue(false)
                showError.postValue(true)
            }
        }
    }
}