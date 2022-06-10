package com.example.apptechnicaltestflock.viewmodel.listcocktailsfragment

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.apptechnicaltestflock.Model.dataforcocktailslist.MyInfoOfCocktails
import com.example.apptechnicaltestflock.databinding.ViewForAllCocktailsBinding
import com.squareup.picasso.Picasso

class ListCocktailsHolder(view: View) : RecyclerView.ViewHolder(view) {

    private var binding = ViewForAllCocktailsBinding.bind(view)

    fun paintIt(cocktail: MyInfoOfCocktails) {

        //set the name of the hero in the text

        binding.tvCocktail.text = cocktail.strDrink

        //set the image

        Picasso.get().load(cocktail.strDrinkThumb).into(binding.imCocktail)
    }
}