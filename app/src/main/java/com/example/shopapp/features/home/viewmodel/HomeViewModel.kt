package com.example.shopapp.features.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shopapp.app.utils.State
import com.example.shopapp.features.home.data.model.Category
import com.example.shopapp.features.home.data.model.Product
import com.example.shopapp.features.home.data.repository.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: HomeRepository) : ViewModel() {

    private val _categoryState = MutableStateFlow<State<List<Category>>>(State.Idle)
    private val _productsState = MutableStateFlow<State<List<Product>>>(State.Idle)
    private val _categoryLimit = MutableStateFlow(10)

    fun getCategory(){
        _categoryState.value = State.Loading
        viewModelScope.launch {
            try {

                when(val result = repository.getCategory(_categoryLimit.value)){

                }

            } catch (e: Exception) {
                _categoryState.value = State.Error(e.message ?: "Unknown Error")
            }
        }
    }

    fun getProducts(){

    }
}