package com.example.mynewproject.ui.alcoholiccontent

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mynewproject.data.model.DrinkModel
import com.example.mynewproject.data.model.alcoholic.AlcoholicContentModel
import com.example.mynewproject.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AlcoholicconViewModel @Inject constructor(
    val repository: Repository
) : ViewModel() {


//    val alcohol = MutableLiveData<DrinkModel>()



   val alcohol = MutableLiveData<AlcoholicContentModel>()
   fun getAlcoholContent(){
//
        viewModelScope.launch {
            val result = repository.getAlcoholContent()
            alcohol.postValue(result)
        }
    }
}


//    val alcohol = MutableLiveData<List<DrinkModelAlcoholic>?>()



//    fun getAlcoholContent(){
//        viewModelScope.launch {
//           val result = repository.getAlcoholContent()
////            alcohol.postValue(result)
//            alcohol.postValue(listOf(repository.getAlcoholContent()))
//
//






