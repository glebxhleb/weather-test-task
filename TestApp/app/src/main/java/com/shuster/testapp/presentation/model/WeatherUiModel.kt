package com.shuster.testapp.presentation.model

data class WeatherUiModel(
    val iconUrl: String,
    val minTemp: String,
    val maxTemp: String,
    val humidity: String,
    val windSpeed: String,
    val windDegree: String,
    val description: String,
)