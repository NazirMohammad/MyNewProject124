package com.example.mynewproject.data.model.alcoholic


import com.google.gson.annotations.SerializedName

data class DrinkModelAlcoholic(
    @SerializedName("idDrink")
    val idDrink: String? = "",
    @SerializedName("strDrink")
    val strDrink: String? = "",
    @SerializedName("strDrinkThumb")
    val strDrinkThumb: String? = ""
) : java.io.Serializable