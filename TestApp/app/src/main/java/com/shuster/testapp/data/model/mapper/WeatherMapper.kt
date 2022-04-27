package com.shuster.testapp.data.model.mapper

import com.shuster.testapp.data.model.WeatherResponse
import com.shuster.testapp.domain.model.Weather
import java.math.BigDecimal
import javax.inject.Inject

class WeatherMapper @Inject constructor() {

    fun map(response: WeatherResponse) =
        Weather(
            location = response.name,
            iconUrl = response.weather.firstOrNull()?.icon.orEmpty(),
            minTemp = response.main.temp_min,
            maxTemp = response.main.temp_max,
            humidity = response.main.humidity,
            windSpeed = response.wind.speed,
            windDegree = response.wind.deg,
            description = response.weather.firstOrNull()?.description.orEmpty()
        )
}