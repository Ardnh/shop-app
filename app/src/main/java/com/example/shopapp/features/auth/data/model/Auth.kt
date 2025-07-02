package com.example.shopapp.features.auth.data.model

import com.google.gson.annotations.SerializedName

data class LoginRequest(
    val email: String = "",
    val password: String = ""
)

data class LoginData(
    val accessToken: String? = null,
    val refreshToken: String? = null
)

data class LoginResponse(
    @SerializedName("access_token")
    val accessToken: String? = null,

    @SerializedName("refresh_token")
    val refreshToken: String? = null
)

data class RefreshTokenRequest(
    @SerializedName("refresh_token")
    val refreshToken: String = ""
)