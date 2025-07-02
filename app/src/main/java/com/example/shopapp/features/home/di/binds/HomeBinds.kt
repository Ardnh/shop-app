package com.example.shopapp.features.home.di.binds

import com.example.shopapp.features.home.data.remote.HomeRemoteDataSource
import com.example.shopapp.features.home.data.remote.HomeRemoteDataSourceImpl
import com.example.shopapp.features.home.data.repository.HomeRepository
import com.example.shopapp.features.home.data.repository.HomeRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class HomeBinds {

    @Binds
    @Singleton
    abstract fun bindHomeRemoteDataSource(impl: HomeRemoteDataSourceImpl): HomeRemoteDataSource

    @Binds
    @Singleton
    abstract fun bindHomeRepository(impl: HomeRepositoryImpl): HomeRepository
}