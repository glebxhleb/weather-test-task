package com.shuster.testapp.data.network

import com.shuster.testapp.data.model.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("weather")
    suspend fun fetchWeather(
        @Query("q") city: String,
        @Query("units") units: String,
    ): WeatherResponse
}