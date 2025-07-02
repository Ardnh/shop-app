package com.example.shopapp.features.auth.viewmodel

import android.content.Context
import com.example.shopapp.features.auth.data.model.LoginRequest
import com.example.shopapp.features.auth.data.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import androidx.lifecycle.ViewModel
import com.example.shopapp.features.auth.data.model.LoginData
import com.example.shopapp.app.utils.State
import com.example.shopapp.app.utils.StorageServiceWrapper
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@HiltViewModel
class AuthViewModel @Inject constructor(@ApplicationContext private val context: Context, private val authRepository: AuthRepository) : ViewModel() {

    private val _loginState = MutableStateFlow<State<LoginData>>(State.Idle)

    val loginData: StateFlow<State<LoginData>> = _loginState

    fun login(email: String, password: String){

        _loginState.value = State.Loading
        viewModelScope.launch {

            try {

                val req = LoginRequest(email, password)
                val result = authRepository.loginRepository(req)

                val accessToken = result.accessToken
                val refreshToken = result.refreshToken

                if (accessToken != null && refreshToken != null) {
                    StorageServiceWrapper.saveToken(context, accessToken, refreshToken)
                    _loginState.value = State.Success(
                        LoginData(
                            accessToken = accessToken,
                            refreshToken = refreshToken
                        )
                    )
                } else {
                    _loginState.value = State.Error("Failed to save login response")
                }

            } catch (e: Exception) {
                _loginState.value = State.Error(e.message ?: "Unkown error")
            }

        }

    }

}