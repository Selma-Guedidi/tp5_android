package com.example.tp5.forecast_models

data class ForecastResponse(
    val city: City,
    val cnt: Int,
    val cod: String,
    val list: List<Infos>,
    val message: Double
)