package com.example.shopapp.features.home.data.repository

import com.example.shopapp.features.home.data.model.Category
import com.example.shopapp.features.home.data.model.Product
import com.example.shopapp.features.home.data.model.ProductsParams
import com.example.shopapp.features.home.data.remote.HomeApiService
import retrofit2.Response
import javax.inject.Inject

interface HomeRepository {
    suspend fun getCategory(limit: Int) : Result<List<Category>>
    suspend fun getProducts(req: ProductsParams) : Result<List<Product>>
}

// Fungsi
// Abstraksi dari data layer
// Mengambil data dari API, Database, Cache, dsb
// Menangani logika pengambilan data

class HomeRepositoryImpl @Inject constructor(private val apiService: HomeApiService) : HomeRepository {

    override suspend fun getCategory(limit: Int): Result<List<Category>> {

        return try {
            val result = apiService.getCategories(limit)
            if(result.isSuccessful){
                val categories =  result.body()
                if (categories != null) {
                    Result.success(categories)
                } else {
                    Result.failure(Exception("Empty response body"))
                }
            } else {
                val errorMsg = result.errorBody()?.string() ?: "Unknown API error"
                Result.failure(Exception("API Error: $errorMsg"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }

    }

    override suspend fun getProducts(req: ProductsParams): Result<List<Product>> {

        return try {

            val result = apiService.getProducts(
                title = req.title,
                priceMin = req.priceMin,
                priceMax = req.priceMax,
                limit = req.limit,
                offset = req.limit,
                categoryId = req.categoryId
            )

            if(result.isSuccessful){
                val products = result.body()
                if (products != null) {
                    Result.success(products)
                } else {
                    Result.failure(Exception("Empty response body"))
                }
            } else {
                val errorMsg = result.errorBody()?.string() ?: "Unknown API error"
                Result.failure(Exception("API Error: $errorMsg"))
            }

        } catch (e: Exception) {
            Result.failure(e)
        }

    }

}