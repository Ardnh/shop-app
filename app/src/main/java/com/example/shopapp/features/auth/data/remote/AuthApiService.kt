package com.example.shopapp.features.auth.data.remote

import com.example.shopapp.features.auth.data.model.LoginRequest
import com.example.shopapp.features.auth.data.model.LoginResponse
import com.example.shopapp.features.auth.data.model.RefreshTokenRequest
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApiService {

    @POST("auth/login")
    suspend fun login(@Body req: LoginRequest) : LoginResponse

    @POST("auth/refresh-token")
    suspend fun refreshToken(@Body req: RefreshTokenRequest) : LoginResponse

}