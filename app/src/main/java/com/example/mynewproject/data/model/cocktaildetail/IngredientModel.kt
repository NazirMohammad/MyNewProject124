package com.example.mynewproject.data.model.cocktaildetail


import com.google.gson.annotations.SerializedName

data class IngredientModel(
    @SerializedName("idIngredient")
    val idIngredient: String? = "",
    @SerializedName("strABV")
    val strABV: String? = "",
    @SerializedName("strAlcohol")
    val strAlcohol: String? = "",
    @SerializedName("strDescription")
    val strDescription: String? = "",
    @SerializedName("strIngredient")
    val strIngredient: String? = "",
    @SerializedName("strType")
    val strType: String? = ""
): java.io.Serializable