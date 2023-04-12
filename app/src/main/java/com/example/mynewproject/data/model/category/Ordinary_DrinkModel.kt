package com.example.mynewproject.data.model.category


import com.google.gson.annotations.SerializedName

data class Ordinary_DrinkModel(
    @SerializedName("drinks")
    val drinks: List<DrinkModel?>? = listOf()
): java.io.Serializable