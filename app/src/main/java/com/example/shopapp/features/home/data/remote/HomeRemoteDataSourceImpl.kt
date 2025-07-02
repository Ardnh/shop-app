package com.example.shopapp.features.home.data.remote

import com.example.shopapp.features.home.data.model.Category
import com.example.shopapp.features.home.data.model.Product
import com.example.shopapp.features.home.data.model.ProductsParams
import retrofit2.Response
import javax.inject.Inject

interface HomeRemoteDataSource {
    suspend fun getCategory(limit: Int) : Response<List<Category>>
    suspend fun getProducts(req: ProductsParams) : Response<List<Product>>
}

class HomeRemoteDataSourceImpl @Inject constructor(private val api: HomeApiService) : HomeRemoteDataSource {

    override suspend fun getCategory(limit: Int): Response<List<Category>> {
        return api.getCategories(limit)
    }

    override suspend fun getProducts(req: ProductsParams): Response<List<Product>> {

        return api.getProducts(
            title = req.title,
            priceMin = req.priceMin,
            priceMax = req.priceMax,
            limit = req.limit,
            offset = req.offset,
            categoryId = req.categoryId
        )
    }

}