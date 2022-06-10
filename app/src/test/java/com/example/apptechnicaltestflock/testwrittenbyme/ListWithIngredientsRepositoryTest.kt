package com.example.apptechnicaltestflock.testwrittenbyme

import com.example.apptechnicaltestflock.Model.dataforingredientslist.Ingredient
import com.example.apptechnicaltestflock.Model.dataforingredientslist.IngredientsDrinksDto
import com.example.apptechnicaltestflock.apiservice.getlistingredients.ListIngredientsService
import com.example.apptechnicaltestflock.apiservice.getlistingredients.ListWithIngredientsRepository
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

internal class ListWithIngredientsRepositoryTest{

    @RelaxedMockK
    private lateinit var api: ListIngredientsService

    private lateinit var repository: ListWithIngredientsRepository

    @Before
    fun onBefore(){
        MockKAnnotations.init(this)
        repository = ListWithIngredientsRepository(api)
    }

    @Test
    fun `when the api does not return the IngredientsDrinksDto`()= runBlocking{
        //given
        coEvery { api.getIngredients() } returns IngredientsDrinksDto(emptyList())
        //then
        val list1 = repository.getAllIngredientsFromApi()
        //when
        assert(list1== emptyList<Ingredient>())
    }
}