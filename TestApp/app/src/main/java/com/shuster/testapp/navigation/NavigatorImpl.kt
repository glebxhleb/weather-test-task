package com.shuster.testapp.navigation

import kotlinx.coroutines.flow.MutableSharedFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NavigatorImpl @Inject constructor() : Navigator {

    override val navigationFlow = MutableSharedFlow<Route>()

    override suspend fun navigate(route: Route) {
        navigationFlow.emit(route)
    }
}