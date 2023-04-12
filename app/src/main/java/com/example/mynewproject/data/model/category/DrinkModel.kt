package com.example.mynewproject.data.model.category


import com.google.gson.annotations.SerializedName

data class DrinkModel(
    @SerializedName("idDrink")
    val idDrink: String? = "",
    @SerializedName("strDrink")
    val strDrink: String? = "",
    @SerializedName("strDrinkThumb")
    val strDrinkThumb: String? = ""
): java.io.Serializable