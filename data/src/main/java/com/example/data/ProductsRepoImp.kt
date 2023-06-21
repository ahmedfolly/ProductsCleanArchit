package com.example.data

import com.example.Result
import com.example.domain.ProductRepo
import com.example.domain.entity.Products

class ProductsRepoImp(val apiService: APIService) : ProductRepo {
    override suspend fun getProducts(): Result<Products> {
        return try {
            Result.Success(apiService.getAllProducts())
        } catch (e: Exception) {
            Result.Error(e)
        }
    }

}