package com.shuster.testapp.presentation.weather_details.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shuster.testapp.common.Failure
import com.shuster.testapp.common.Result
import com.shuster.testapp.common.Success
import com.shuster.testapp.domain.model.Weather
import com.shuster.testapp.domain.repository.WeatherRepository
import com.shuster.testapp.presentation.model.mapper.WeatherUiMapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherDetailsViewModel @Inject constructor(
    private val weatherRepository: WeatherRepository,
    private val mapper: WeatherUiMapper,
) : ViewModel() {

    private val _weatherResult: MutableStateFlow<WeatherDetailsSate> = MutableStateFlow(WeatherDetailsSate.Loading)

    val weatherResult: StateFlow<WeatherDetailsSate> = _weatherResult.asStateFlow()

    fun setCity(cityName: String) {
        viewModelScope.launch {
            handleResult(weatherRepository.fetchWeather(cityName, UNITS))
        }
    }

    private fun handleResult(result: Result<Weather>) =
        when (result) {
            is Success -> _weatherResult.tryEmit(WeatherDetailsSate.Success(mapper.map(result.data)))
            is Failure -> _weatherResult.tryEmit(WeatherDetailsSate.Error(result.exception.message ?: "error"))
        }

    companion object {
        const val UNITS = "metric"
    }
}