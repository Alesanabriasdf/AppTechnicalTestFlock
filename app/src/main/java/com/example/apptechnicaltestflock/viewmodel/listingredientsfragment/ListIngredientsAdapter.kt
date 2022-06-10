package com.example.apptechnicaltestflock.viewmodel.listingredientsfragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.apptechnicaltestflock.Model.dataforingredientslist.Ingredient
import com.example.apptechnicaltestflock.R

class ListIngredientsAdapter(private val list: List<Ingredient>) :
    RecyclerView.Adapter<ListIngredientsHolder>() {

    //private val filteredList= arrayListOf<List<Ingredient>>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListIngredientsHolder {
        val layout = LayoutInflater.from(parent.context)
        return ListIngredientsHolder(layout.inflate(R.layout.view_for_all_ingredients, parent, false))
    }

    override fun onBindViewHolder(
        holder: ListIngredientsHolder,
        position: Int
    ) {
        holder.paintIt(list[position])
    }

    override fun getItemCount(): Int = list.size

    /*fun filter(ingredient: String){
        if (ingredient.isBlank()){
            filteredList.clear()
            filteredList.add(list)
        } else {
            for (findedIngredient in list){
                if (findedIngredient.strIngredient1.contains(ingredient)){
                    val listWithIngredientsFinded= mutableListOf<Ingredient>()
                    listWithIngredientsFinded.add(findedIngredient)
                    filteredList.add((listWithIngredientsFinded))
                }
            }
        }
    }*/
}