package com.example.mynewproject.data.model.alcoholic


import com.google.gson.annotations.SerializedName

data class AlcoholicContentModel(
    @SerializedName("drinks")
    val drinks: List<DrinkModelAlcoholic?>? = listOf()
): java.io.Serializable