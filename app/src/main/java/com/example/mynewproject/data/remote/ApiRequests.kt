package com.example.mynewproject.data.remote

import com.example.mynewproject.data.model.DrinksModel
import com.example.mynewproject.data.model.alcoholic.AlcoholicContentModel
import com.example.mynewproject.data.model.alcoholic.DrinkModelAlcoholic
import com.example.mynewproject.data.model.category.DrinkModel
import com.example.mynewproject.data.model.category.Ordinary_DrinkModel
import com.example.mynewproject.data.model.cocktaildetail.CocktailDetailsModel
import com.example.mynewproject.data.model.cocktaildetail.IngredientModel
import com.example.mynewproject.data.model.ingredient.DrinkModelGin
import com.example.mynewproject.data.model.ingredient.GinModel
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiRequests {






    @GET(ApiDetails.ginModel)
    suspend fun getGinmodel(): GinModel
    @GET (ApiDetails.alcoholicContentModel)
    suspend fun getAlcoholContent(): AlcoholicContentModel
   @GET(ApiDetails.ordinaryDrinkmodel)
   //category
   suspend fun getOrdinarydrink():Ordinary_DrinkModel
   @GET(ApiDetails.cocktailDetailsModel)
    suspend fun getCocktails():CocktailDetailsModel



}




