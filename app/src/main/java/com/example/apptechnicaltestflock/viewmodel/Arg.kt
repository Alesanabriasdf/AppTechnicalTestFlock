package com.example.apptechnicaltestflock.viewmodel

import android.content.Context
import com.example.apptechnicaltestflock.view.FragmentListOfCocktailsWithThatIngredient

class Arg(val context: Context) {

    private val storage = context.getSharedPreferences("ingredient",0)!!

    fun colectId(id: String){
        storage.edit().putString("ingredient",id).apply()
    }
    fun getId():String{
        return storage.getString("ingredient","")!!
    }
}