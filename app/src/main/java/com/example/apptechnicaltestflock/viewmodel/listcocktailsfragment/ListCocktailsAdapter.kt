package com.example.apptechnicaltestflock.viewmodel.listcocktailsfragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.apptechnicaltestflock.Model.dataforcocktailslist.MyInfoOfCocktails
import com.example.apptechnicaltestflock.R

class ListCocktailsAdapter (private val list: List<MyInfoOfCocktails>) :
        RecyclerView.Adapter<ListCocktailsHolder>() {

        override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
        ): ListCocktailsHolder {
            val layout = LayoutInflater.from(parent.context)
            return ListCocktailsHolder(layout.inflate(R.layout.view_for_all_cocktails, parent, false))
        }

        override fun onBindViewHolder(
            holder: ListCocktailsHolder,
            position: Int
        ) {
            holder.paintIt(list[position])
        }

        override fun getItemCount(): Int = list.size
}