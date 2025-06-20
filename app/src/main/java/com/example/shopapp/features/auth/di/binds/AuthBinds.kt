package com.example.shopapp.features.auth.di.binds

import com.example.shopapp.features.auth.data.remote.AuthApiService
import com.example.shopapp.features.auth.data.remote.AuthRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AuthBinds {
    @Binds
    @Singleton
    abstract fun bindAuthRemoteDataSource(impl : AuthRemoteDataSourceImpl) : AuthApiService
}