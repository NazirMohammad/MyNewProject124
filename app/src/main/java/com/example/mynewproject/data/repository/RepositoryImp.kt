package com.example.mynewproject.data.repository

import com.example.mynewproject.data.remote.ApiRequests
import javax.inject.Inject

class RepositoryImp @Inject constructor(
    val apiRequests: ApiRequests
): Repository {

    override suspend fun getGinmodel()= apiRequests.getGinmodel()
    override suspend fun getAlcoholContent()= apiRequests.getAlcoholContent()
   override suspend fun getOrdinarydrink()=apiRequests.getOrdinarydrink()
    override suspend fun getCocktails()=apiRequests.getCocktails()

}