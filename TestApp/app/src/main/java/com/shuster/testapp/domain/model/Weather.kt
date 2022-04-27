package com.shuster.testapp.domain.model

import java.math.BigDecimal

data class Weather(
    val location: String,
    val iconUrl: String,
    val minTemp: BigDecimal,
    val maxTemp: BigDecimal,
    val humidity: Int,
    val windSpeed: BigDecimal,
    val windDegree: Int,
    val description: String,
)
