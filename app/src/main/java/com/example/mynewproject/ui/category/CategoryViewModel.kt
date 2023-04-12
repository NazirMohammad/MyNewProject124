package com.example.mynewproject.ui.category

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mynewproject.data.model.category.DrinkModel
import com.example.mynewproject.data.model.category.Ordinary_DrinkModel
import com.example.mynewproject.data.model.ingredient.GinModel
import com.example.mynewproject.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(
    val repository: Repository
): ViewModel() {


    var category = MutableLiveData<Ordinary_DrinkModel>()

    fun getOrdinarydrink(){
        viewModelScope.launch {
            category.postValue(repository.getOrdinarydrink())
}}}