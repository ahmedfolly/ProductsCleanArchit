package com.example.domain

class GetProductsUseCase (private val repo: ProductRepo) {
   suspend operator fun invoke()=repo.getProducts()
}