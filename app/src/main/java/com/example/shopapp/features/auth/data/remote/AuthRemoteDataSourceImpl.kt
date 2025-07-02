package com.example.shopapp.features.auth.data.remote

import com.example.shopapp.features.auth.data.model.LoginRequest
import com.example.shopapp.features.auth.data.model.LoginResponse
import com.example.shopapp.features.auth.data.model.RefreshTokenRequest
import javax.inject.Inject


interface AuthRemoteDataSource {
    suspend fun login(req: LoginRequest) : LoginResponse
    suspend fun refreshToken(activeRefreshToken: String) : LoginResponse
}

class AuthRemoteDataSourceImpl @Inject constructor(private val api: AuthApiService) : AuthRemoteDataSource {

    override suspend fun login(req: LoginRequest): LoginResponse {
        return api.login(req)
    }

    override suspend fun refreshToken(activeRefreshToken: String): LoginResponse {
        return api.refreshToken(RefreshTokenRequest(refreshToken = activeRefreshToken))
    }

}