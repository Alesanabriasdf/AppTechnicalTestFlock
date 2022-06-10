package com.example.apptechnicaltestflock.view

import android.content.Context.INPUT_METHOD_SERVICE
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.RecyclerView
import com.example.apptechnicaltestflock.Model.dataforingredientslist.Ingredient
import com.example.apptechnicaltestflock.R
import com.example.apptechnicaltestflock.databinding.FragmentListIngredientsBinding
import com.example.apptechnicaltestflock.viewmodel.listingredientsfragment.ListIngredientsAdapter
import com.example.apptechnicaltestflock.viewmodel.listingredientsfragment.ListIngredientsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentListIngredients : Fragment(R.layout.fragment_list_ingredients) {

    private val listIngredientsViewModel: ListIngredientsViewModel by activityViewModels()

    private lateinit var adapter: ListIngredientsAdapter

    private lateinit var binding: FragmentListIngredientsBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentListIngredientsBinding.bind(view)

        adapter = ListIngredientsAdapter(emptyList())

        listIngredientsViewModel.onGetAllIngredients()

        binding.rootView.setOnClickListener{
            hideKeyboard()
        }

        binding.rvForAllIngredients.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (dy > 2 ) {
                    binding.etSearchByIngredient.isVisible=false
                    binding.iconLens.isVisible=false
                    hideKeyboard()
                } else if (dy < 2 ) {
                    binding.etSearchByIngredient.isVisible=true
                    binding.iconLens.isVisible=true
                }
            }
        })

        binding.etSearchByIngredient.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                Log.d("filtro", p0.toString())
                val newList = mutableListOf<Ingredient>()
                listIngredientsViewModel.listOfAllIngredients.observe(viewLifecycleOwner) { listWithIngredients ->
                    listWithIngredients.forEach {
                        if ( it.strIngredient1.lowercase().contains(p0.toString().lowercase())){
                        newList.add(it)
                        }
                    }
                }

                binding.rvForAllIngredients.adapter = ListIngredientsAdapter(newList)
                adapter.notifyDataSetChanged()
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })



        listIngredientsViewModel.loading.observe(viewLifecycleOwner) {
            binding.progressBar.isVisible = it
        }

        listIngredientsViewModel.listOfAllIngredients.observe(viewLifecycleOwner) {
            binding.rvForAllIngredients.adapter = ListIngredientsAdapter(it!!)
        }

        listIngredientsViewModel.showError.observe(viewLifecycleOwner) {
            binding.tvForError.isVisible = it
        }
    }

    fun hideKeyboard() {
        val imm = activity?.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view!!.windowToken, 0)
    }
}