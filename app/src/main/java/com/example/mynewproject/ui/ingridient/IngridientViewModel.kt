package com.example.mynewproject.ui.ingridient

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mynewproject.data.model.category.DrinkModel
import com.example.mynewproject.data.model.ingredient.GinModel
import com.example.mynewproject.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class IngridientViewModel @Inject constructor(
    val repository: Repository
) : ViewModel() {

    var gin = MutableLiveData<GinModel>()

   fun getGinmodel(){
       viewModelScope.launch {
           gin.postValue(repository.getGinmodel())
//           gin.postValue(repository.getGinmodel() as List<DrinkModelGin>?)
       }
   }
}




//    private val _text = MutableLiveData<String>().apply {
//        value = "This is notifications Fragment"
//    }
//    val text: LiveData<String> = _text
//}