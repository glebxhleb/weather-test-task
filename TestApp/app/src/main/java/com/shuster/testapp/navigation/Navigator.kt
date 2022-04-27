package com.shuster.testapp.navigation

import kotlinx.coroutines.flow.SharedFlow

interface Navigator {

    val navigationFlow: SharedFlow<Route>

    suspend fun navigate(route: Route)
}