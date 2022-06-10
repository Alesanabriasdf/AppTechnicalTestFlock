package com.example.apptechnicaltestflock.viewmodel.listingredientsfragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apptechnicaltestflock.Model.dataforingredientslist.Ingredient
import com.example.apptechnicaltestflock.viewmodel.usescase.GetAllIngredients
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListIngredientsViewModel @Inject constructor(private val getAllIngredients: GetAllIngredients) :
    ViewModel() {

    var listOfAllIngredients = MutableLiveData<List<Ingredient>>()

    val loading = MutableLiveData<Boolean>()

    val showError = MutableLiveData<Boolean>()

    fun onGetAllIngredients() {
        viewModelScope.launch {
            loading.postValue(true)
            try {
                val listWithIngredients = getAllIngredients()
                listOfAllIngredients.value = listWithIngredients
                loading.postValue(false)
            } catch (e: Exception) {
                loading.postValue(false)
                showError.postValue(true)
            }
        }
    }
}