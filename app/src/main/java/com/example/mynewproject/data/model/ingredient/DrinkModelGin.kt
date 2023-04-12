package com.example.mynewproject.data.model.ingredient


import com.google.gson.annotations.SerializedName

data class DrinkModelGin(
    @SerializedName("idDrink")
    val idDrink: String? = "",
    @SerializedName("strDrink")
    val strDrink: String? = "",
    @SerializedName("strDrinkThumb")
    val strDrinkThumb: String? = ""
) : java.io.Serializable