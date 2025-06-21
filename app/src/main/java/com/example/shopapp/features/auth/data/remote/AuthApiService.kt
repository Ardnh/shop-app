package com.example.shopapp.features.auth.data.remote

import com.example.shopapp.features.auth.data.model.LoginRequest
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApiService {
    @POST("/auth/login")
    suspend fun login(@Body req: LoginRequest)
}