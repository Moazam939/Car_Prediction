package com.example.carprediction.models

data class request(
    val year: Int,
    val present_price: Double,
    val driven_kms: Int,
    val owner: Int,
    val car_name: String,
    val fuel_type: String,
    val selling_type: String,
    val transmission: String

)
//x = dataset[["Year", "Present_Price", "Driven_kms", "Owner", "car_name_int", "Fuel_Type_int", "Selling_type_int", "Transmission_int"]]