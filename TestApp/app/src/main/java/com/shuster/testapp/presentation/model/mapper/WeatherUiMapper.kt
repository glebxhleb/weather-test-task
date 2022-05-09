package com.shuster.testapp.presentation.model.mapper

import com.shuster.testapp.domain.model.Weather
import com.shuster.testapp.presentation.model.WeatherUiModel
import com.shuster.testapp.presentation.utils.toStringWithSign
import java.math.BigDecimal.ROUND_HALF_UP
import javax.inject.Inject

class WeatherUiMapper @Inject constructor() {

    fun map(domainModel: Weather) =
        WeatherUiModel(
            iconUrl = "http://openweathermap.org/img/wn/${domainModel.iconUrl}@2x.png",
            minTemp = domainModel.minTemp.setScale(1, ROUND_HALF_UP).toStringWithSign(),
            maxTemp = domainModel.maxTemp.setScale(1, ROUND_HALF_UP).toStringWithSign(),
            humidity = domainModel.humidity.toString(),
            windSpeed = domainModel.windSpeed.setScale(1, ROUND_HALF_UP).toString(),
            windDegree = domainModel.windDegree.toString(),
            description = domainModel.description,
        )
}