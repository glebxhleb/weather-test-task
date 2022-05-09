package com.shuster.testapp.di.modules

import com.shuster.testapp.navigation.Navigator
import com.shuster.testapp.navigation.NavigatorImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface NavigationModule {

    @Binds
    fun mapNavigation(navigator: NavigatorImpl): Navigator
}