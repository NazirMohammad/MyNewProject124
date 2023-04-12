package com.example.mynewproject.data.model.cocktaildetail


import com.google.gson.annotations.SerializedName

data class CocktailDetailsModel(
    @SerializedName("ingredients")
    val ingredients: List<IngredientModel?>? = listOf()
): java.io.Serializable