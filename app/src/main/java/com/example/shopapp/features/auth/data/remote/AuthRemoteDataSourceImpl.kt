package com.example.shopapp.features.auth.data.remote

import com.example.shopapp.features.auth.data.model.LoginRequest
import javax.inject.Inject

class AuthRemoteDataSourceImpl @Inject constructor(private val api: AuthApiService ) {
    suspend fun login(email: String, password: String) {
        val req = LoginRequest(email, password)
        return api.login(req)
    }
}