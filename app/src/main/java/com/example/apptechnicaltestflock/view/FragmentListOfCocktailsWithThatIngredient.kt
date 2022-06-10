package com.example.apptechnicaltestflock.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import com.example.apptechnicaltestflock.R
import com.example.apptechnicaltestflock.databinding.FragmentListOfCocktailsWithThatIngredientBinding
import com.example.apptechnicaltestflock.view.MainActivity.Companion.arg
import com.example.apptechnicaltestflock.viewmodel.listcocktailsfragment.ListCocktailsAdapter
import com.example.apptechnicaltestflock.viewmodel.listcocktailsfragment.ListOFCocktailsWithThatIngredientViewModel
import com.example.apptechnicaltestflock.viewmodel.listingredientsfragment.ListIngredientsAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentListOfCocktailsWithThatIngredient : Fragment(R.layout.fragment_list_of_cocktails_with_that_ingredient) {

    val listOFCocktailsWithThatIngredientViewModel: ListOFCocktailsWithThatIngredientViewModel by activityViewModels()

    private lateinit var binding: FragmentListOfCocktailsWithThatIngredientBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arg.colectId(arguments?.getString("ingredient")!!)

        binding = FragmentListOfCocktailsWithThatIngredientBinding.bind(view)

        listOFCocktailsWithThatIngredientViewModel.onGetAllCocktails()

        listOFCocktailsWithThatIngredientViewModel.loading.observe(viewLifecycleOwner) {
            binding.progressBar.isVisible = it
        }

        listOFCocktailsWithThatIngredientViewModel.listOfAllCocktails.observe(viewLifecycleOwner) {
            binding.rvForAllCocktails.adapter = ListCocktailsAdapter(it!!)
        }


        listOFCocktailsWithThatIngredientViewModel.showError.observe(viewLifecycleOwner) {
            binding.tvForError.isVisible = it
        }
    }
}