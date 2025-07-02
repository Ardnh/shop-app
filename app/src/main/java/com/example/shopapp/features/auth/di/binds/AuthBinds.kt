package com.example.shopapp.features.auth.di.binds

import com.example.shopapp.features.auth.data.remote.AuthRemoteDataSource
import com.example.shopapp.features.auth.data.remote.AuthRemoteDataSourceImpl
import com.example.shopapp.features.auth.data.repository.AuthRepository
import com.example.shopapp.features.auth.data.repository.AuthRepositoryImpl
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
    abstract fun bindAuthRemoteDataSource(impl : AuthRemoteDataSourceImpl) : AuthRemoteDataSource

    @Binds
    @Singleton
    abstract fun bindUserRepository(impl: AuthRepositoryImpl) : AuthRepository

}