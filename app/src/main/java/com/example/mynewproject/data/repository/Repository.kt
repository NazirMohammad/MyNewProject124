package com.example.mynewproject.data.repository

import com.example.mynewproject.data.model.alcoholic.AlcoholicContentModel
import com.example.mynewproject.data.model.alcoholic.DrinkModelAlcoholic
import com.example.mynewproject.data.model.category.DrinkModel
import com.example.mynewproject.data.model.category.Ordinary_DrinkModel
import com.example.mynewproject.data.model.cocktaildetail.CocktailDetailsModel
import com.example.mynewproject.data.model.cocktaildetail.IngredientModel
import com.example.mynewproject.data.model.ingredient.DrinkModelGin
import com.example.mynewproject.data.model.ingredient.GinModel

interface Repository {

    suspend fun getGinmodel(): GinModel

    suspend fun getAlcoholContent():AlcoholicContentModel

    suspend fun getOrdinarydrink():Ordinary_DrinkModel

  suspend fun getCocktails():CocktailDetailsModel

}