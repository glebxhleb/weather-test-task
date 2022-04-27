package com.shuster.testapp.presentation.cities_list.viewmodel

import com.shuster.testapp.presentation.model.City

sealed class CitiesState

data class CitiesList(val cities: List<City>): CitiesState()