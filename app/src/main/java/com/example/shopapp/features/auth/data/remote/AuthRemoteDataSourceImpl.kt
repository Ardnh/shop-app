package com.example.shopapp.features.auth.data.remote

import com.example.shopapp.features.auth.data.model.LoginRequest
import javax.inject.Inject


interface AuthRemoteDataSource {
    suspend fun login(req: LoginRequest)
}

class AuthRemoteDataSourceImpl @Inject constructor(private val api: AuthApiService) : AuthRemoteDataSource {

    override suspend fun login(req: LoginRequest) {

        return api.login(req)
    }
}