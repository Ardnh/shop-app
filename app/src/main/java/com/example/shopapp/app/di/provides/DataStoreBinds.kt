package com.example.shopapp.app.di.provides

import com.example.shopapp.app.utils.StorageService
import com.example.shopapp.app.utils.StorageServiceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataStoreBinds {

    @Binds
    @Singleton
    abstract fun dataStoreBinds(impl: StorageServiceImpl) : StorageService

}