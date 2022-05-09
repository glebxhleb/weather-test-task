package com.shuster.testapp.domain.repository

import com.shuster.testapp.common.Result
import com.shuster.testapp.domain.model.Weather

interface WeatherRepository {

    suspend fun fetchWeather(city: String, units: String): Result<Weather>
}