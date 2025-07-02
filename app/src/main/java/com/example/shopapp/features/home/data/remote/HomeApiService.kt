package com.example.shopapp.features.home.data.remote

import com.example.shopapp.features.home.data.model.Category
import com.example.shopapp.features.home.data.model.Product
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface HomeApiService {

    @GET("categories")
    suspend fun getCategories(
        @Query("limit") limit: Int
    ) : Response<List<Category>>

    @GET("products")
    suspend fun getProducts(
        @Query("title") title: String?,
        @Query("price_min") priceMin: Int?,
        @Query("price_max") priceMax: Int?,
        @Query("limit") limit: Int?,
        @Query("offset") offset: Int?,
        @Query("categoryId") categoryId: Int?
    ): Response<List<Product>>

}