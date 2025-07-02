package com.example.shopapp.app.utils

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

interface StorageService {
    fun getAccessToken() : Flow<String?>
    fun getRefreshToken() : Flow<String?>
    fun saveToken(accessToken: String, refreshToken: String)
}

class StorageServiceImpl @Inject constructor(@ApplicationContext private val context: Context) : StorageService {

    override fun getAccessToken(): Flow<String?> {
        return StorageServiceWrapper.getAccessToken(context)
    }

    override fun getRefreshToken(): Flow<String?> {
        return StorageServiceWrapper.getRefreshToken(context)
    }

    override fun saveToken(accessToken: String, refreshToken: String) {
        runBlocking {
            StorageServiceWrapper.saveToken(
                context = context,
                accessToken = accessToken,
                refreshToken = refreshToken
            )
        }
    }

}