package com.example.shopapp.features.home.data.model

data class Product(
    val id: Long,
    val title: String,
    val slug: String,
    val price: Long,
    val description: String,
    val category: ProductCategory,
    val images: List<String>,
    val creationAt: String,
    val updatedAt: String,
)

data class ProductCategory(
    val id: Long,
    val name: String,
    val slug: String,
    val image: String,
    val creationAt: String,
    val updatedAt: String,
)

data class ProductsParams(
    val title: String? = null,
    val priceMin: Int? = null,
    val priceMax: Int? = null,
    val limit: Int? = null,
    val offset: Int? = null,
    val categoryId: Int? = null
)
