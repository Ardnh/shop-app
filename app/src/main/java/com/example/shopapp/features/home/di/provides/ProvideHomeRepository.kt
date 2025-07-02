package com.example.shopapp.features.home.di.provides

import com.example.shopapp.features.home.data.remote.HomeApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HomeRepositoryModule {

    @Provides
    @Singleton
    fun provideHomeApiService(retrofit: Retrofit) : HomeApiService {
        return retrofit.create(HomeApiService::class.java)
    }

}