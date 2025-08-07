package com.example.carprediction.retrofit

import com.example.carprediction.models.predictResponse
import com.example.carprediction.models.request


class retrofitRepo {
    suspend fun PredictPrice(request: request): predictResponse? {
        val response = retrofitInstance.api.PredictPrice(request)
        return ((if (response.isSuccessful) {
            response.body()
            }else{
            return null
        }))
    }
}