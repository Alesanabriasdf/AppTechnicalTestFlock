package com.example.apptechnicaltestflock.viewmodel.listingredientsfragment

import android.view.View
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.apptechnicaltestflock.Model.dataforingredientslist.Ingredient
import com.example.apptechnicaltestflock.databinding.ViewForAllIngredientsBinding
import com.example.apptechnicaltestflock.view.FragmentListIngredientsDirections

class ListIngredientsHolder (view: View) : RecyclerView.ViewHolder(view) {

    private var binding = ViewForAllIngredientsBinding.bind(view)

    fun paintIt(ingredient: Ingredient) {
        //set the name of the hero in the text

        binding.tvIngredient.text = ingredient.strIngredient1
        binding.btnToCocktailsWithThatIngredient.text = "Cocktails with : ${ingredient.strIngredient1}"

        //set the navigation to the next fragment

        binding.btnToCocktailsWithThatIngredient.setOnClickListener {
            it.findNavController().navigate(FragmentListIngredientsDirections
                    .actionListIngredientsToListOfCocktailsWithThatIngredient(ingredient.strIngredient1)
            )
        }
    }
}