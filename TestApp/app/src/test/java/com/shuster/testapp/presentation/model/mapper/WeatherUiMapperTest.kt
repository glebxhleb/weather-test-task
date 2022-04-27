package com.shuster.testapp.presentation.model.mapper

import com.shuster.testapp.presentation.utils.createWeather
import org.junit.Assert.*
import org.junit.Test
import java.math.BigDecimal

class WeatherUiMapperTest {

    @Test
    fun `mapper maps some fields`() {
        val mapper = WeatherUiMapper()
        val weatherDomainModel = createWeather(
            location = "Berlin",
            iconUrl = "10d",
            minTemp = BigDecimal(14.23),
            maxTemp = BigDecimal(15.69),
            humidity = 37,
            windSpeed = BigDecimal(12.11),
            windDegree = 178,
            description = "windy",
        )

        val uiWeather = mapper.map(weatherDomainModel)

        assertEquals("http://openweathermap.org/img/wn/10d@2x.png", uiWeather.iconUrl)
        assertEquals("+14.2", uiWeather.minTemp)
        assertEquals("+15.7", uiWeather.maxTemp)
        assertEquals("37", uiWeather.humidity)
        assertEquals("12.1", uiWeather.windSpeed)
        assertEquals("178", uiWeather.windDegree)
        assertEquals("windy", uiWeather.description)
    }
}