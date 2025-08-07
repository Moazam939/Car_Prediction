package com.example.carprediction.retrofit

import com.example.carprediction.models.predictResponse
import com.example.carprediction.models.request
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface retrofitInterface {
    @POST("/predict")
    suspend fun PredictPrice(
        @Body request: request
    ): Response<predictResponse>
}