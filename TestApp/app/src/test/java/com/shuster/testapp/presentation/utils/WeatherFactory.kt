package com.shuster.testapp.presentation.utils

import com.shuster.testapp.domain.model.Weather
import java.math.BigDecimal

fun createWeather(
    location: String = "Paris",
    iconUrl: String = "01d",
    minTemp: BigDecimal = BigDecimal(15.23),
    maxTemp: BigDecimal = BigDecimal(17.65),
    humidity: Int = 87,
    windSpeed: BigDecimal = BigDecimal(15.11),
    windDegree: Int = 78,
    description: String = "windy",
) = Weather(
    location = location,
    iconUrl = iconUrl,
    minTemp = minTemp,
    maxTemp = maxTemp,
    humidity = humidity,
    windSpeed = windSpeed,
    windDegree = windDegree,
    description = description,
)