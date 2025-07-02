package com.example.shopapp.features.auth.data.repository

import com.example.shopapp.features.auth.data.model.LoginRequest
import com.example.shopapp.features.auth.data.model.LoginResponse
import com.example.shopapp.features.auth.data.remote.AuthApiService
import javax.inject.Inject

interface AuthRepository {
    suspend fun loginRepository(req: LoginRequest) : LoginResponse
}

class AuthRepositoryImpl @Inject constructor(private val authApiService: AuthApiService) : AuthRepository {

    override suspend fun loginRepository(req: LoginRequest): LoginResponse {
        return authApiService.login(req)
    }

}