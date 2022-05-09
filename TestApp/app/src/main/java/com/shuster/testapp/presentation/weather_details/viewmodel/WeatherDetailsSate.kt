package com.shuster.testapp.presentation.weather_details.viewmodel

import com.shuster.testapp.presentation.model.WeatherUiModel

sealed class WeatherDetailsSate {

    data class Success(val data: WeatherUiModel) : WeatherDetailsSate()

    data class Error(val message: String) : WeatherDetailsSate()

    object Loading : WeatherDetailsSate()

}