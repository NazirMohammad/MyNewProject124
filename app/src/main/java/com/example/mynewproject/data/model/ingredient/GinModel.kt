package com.example.mynewproject.data.model.ingredient


import com.example.mynewproject.data.model.category.DrinkModel
import com.google.gson.annotations.SerializedName

data class GinModel(
    @SerializedName("drinks")
    val drinks: List<DrinkModelGin?>? = listOf()
): java.io.Serializable