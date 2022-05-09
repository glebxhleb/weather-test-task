package com.shuster.testapp.navigation

import androidx.navigation.NavDirections
import com.shuster.testapp.presentation.cities_list.view.CitiesListFragmentDirections

sealed class Route

object RoteBack: Route()

data class RoteToScreen(val directions: NavDirections): Route()

fun weatherDetailsRoute(cityName: String): Route =
    RoteToScreen(CitiesListFragmentDirections.fromCitiesListToWeatherDetails(cityName))