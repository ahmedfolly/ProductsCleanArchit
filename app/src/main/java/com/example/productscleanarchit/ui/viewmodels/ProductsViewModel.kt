package com.example.productscleanarchit.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.Result
import com.example.domain.GetProductsUseCase
import com.example.domain.entity.Products
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel
@Inject constructor(private val getProductsUseCase: GetProductsUseCase) : ViewModel() {
    private val _products: MutableStateFlow<ProductsState> =
        MutableStateFlow(ProductsState.Loading)
    val products = _products.stateIn(
        viewModelScope,
        SharingStarted.Eagerly,
        initialValue = ProductsState.Loading
    )

    fun fetchData() {
        viewModelScope.launch {
            val response = getProductsUseCase.invoke()
            getAllProducts(response)
        }
    }

    private fun getAllProducts(response: Result<Products>) {
        when (response) {
            is Result.Success -> {
                updateState(ProductsState.Success(response.data))
            }

            is Result.Error -> {
                updateState(ProductsState.Error(response.e))
            }
        }
    }

    private fun updateState(state: ProductsState) {
        _products.update {
            state
        }
    }
}