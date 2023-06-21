package com.example.productscleanarchit.ui.viewmodels

import com.example.domain.entity.Products
import java.lang.Exception

sealed class ProductsState {
    object Loading : ProductsState()
    data class Success(val data: Products) : ProductsState()
    data class Error(val e: Exception) : ProductsState()
}
