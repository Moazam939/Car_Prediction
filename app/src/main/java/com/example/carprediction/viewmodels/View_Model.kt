package com.example.carprediction.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.carprediction.models.predictResponse
import com.example.carprediction.models.request
import com.example.carprediction.retrofit.retrofitRepo
import kotlinx.coroutines.launch

class View_Model : ViewModel() {
    val reposi = retrofitRepo()

    val _view_model = MutableLiveData<predictResponse>()
    val ui_state : LiveData<predictResponse> = _view_model

    fun car_predict_price(response: request){
        viewModelScope.launch {
            val result = reposi.PredictPrice(request = response)
            result.let {
                _view_model.value = it
                Log.d("API_RESPONSE", "Prediction value: ${it?.prediction}")
            }
        }
    }
}