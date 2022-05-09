package com.shuster.testapp.presentation.cities_list.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shuster.testapp.navigation.Navigator
import com.shuster.testapp.navigation.weatherDetailsRoute
import com.shuster.testapp.presentation.model.City
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CitiesListViewModel @Inject constructor(
    private val navigator: Navigator,
) : ViewModel() {

    val data = CitiesList(
        listOf(
            City("Paris"),
            City("Berlin"),
            City("Oslo"),
            City("Lisbon"),
            City("Istanbul"),
            City("Athens"),
            City("Jerusalem"),
            City("Madrid"),
            City("London"),
            City("Rome"),
        )
    )

    fun onCitySelected(city: City) {
        viewModelScope.launch {
            navigator.navigate(weatherDetailsRoute(city.name))
        }
    }
}