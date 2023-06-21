package com.example.data

import com.example.Result
import com.example.domain.entity.Products
import retrofit2.http.GET

interface APIService {
    @GET("products")
    suspend fun getAllProducts(): Products
}