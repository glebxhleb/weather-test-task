package com.shuster.testapp.data.repository

import com.shuster.testapp.common.runCatchingResult
import com.shuster.testapp.data.network.ApiService
import com.shuster.testapp.domain.repository.WeatherRepository
import com.shuster.testapp.common.Result
import com.shuster.testapp.data.model.mapper.WeatherMapper
import com.shuster.testapp.domain.model.Weather
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val mapper: WeatherMapper,
) : WeatherRepository {

    override suspend fun fetchWeather(city: String, units: String): Result<Weather> =
        runCatchingResult {
            mapper.map(apiService.fetchWeather(city, units))
        }
}