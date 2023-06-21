package com.example.domain

import com.example.Result
import com.example.domain.entity.Products

interface ProductRepo {
    suspend fun getProducts():Result<Products>
}