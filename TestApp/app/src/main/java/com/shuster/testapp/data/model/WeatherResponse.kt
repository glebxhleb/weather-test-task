package com.shuster.testapp.data.model

import java.math.BigDecimal

data class WeatherResponse(
    val coord: Coordinates,
    val weather: List<WeatherDescription>,
    val base: String,
    val main: WeatherParameters,
    val visibility: Int,
    val wind: Wind,
    val clouds: Clouds,
    val dt: Int,
    val timeZone: Int,
    val id: Int,
    val name: String,
    val cod: Int,
)

data class Coordinates(
    val lon: BigDecimal,
    val lat: BigDecimal,
)

data class WeatherDescription(
    val id: Int,
    val main: String,
    val description: String,
    val icon: String
)

data class WeatherParameters(
    val temp: BigDecimal,
    val feels_like: BigDecimal,
    val temp_min: BigDecimal,
    val temp_max: BigDecimal,
    val pressure: Int,
    val humidity: Int,
    val sea_level: Int,
    val grnd_level: Int,
)

data class Wind(
    val speed: BigDecimal,
    val deg: Int,
    val gust: BigDecimal,
)

data class Clouds(
    val all: Int,
)