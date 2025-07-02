package com.example.shopapp.app.utils

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

object StorageServiceWrapper {

    private val Context.dataStore by preferencesDataStore(name = "user_prefs")
    private val USER_ACCESS_TOKEN_KEY = stringPreferencesKey("access_token")
    private val USER_REFRESH_TOKEN_KEY = stringPreferencesKey("refresh_token")

    fun getAccessToken(context: Context): Flow<String?> {
        return context.dataStore.data.map { preferences ->
            preferences[USER_ACCESS_TOKEN_KEY]
        }
    }

    fun getRefreshToken(context: Context): Flow<String?> {
        return context.dataStore.data.map { preferences ->
            preferences[USER_REFRESH_TOKEN_KEY]
        }
    }

    suspend fun saveToken(context: Context, accessToken: String, refreshToken: String){
        context.dataStore.edit { preferences ->
            preferences[USER_ACCESS_TOKEN_KEY] = accessToken
            preferences[USER_REFRESH_TOKEN_KEY] = refreshToken
        }
    }
}