package com.shuster.testapp.di.modules

import com.shuster.testapp.data.repository.WeatherRepositoryImpl
import com.shuster.testapp.domain.repository.WeatherRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun mapItemsRepository(repository: WeatherRepositoryImpl): WeatherRepository
}