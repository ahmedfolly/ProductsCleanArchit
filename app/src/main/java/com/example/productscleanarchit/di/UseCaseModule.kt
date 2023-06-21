package com.example.productscleanarchit.di

import com.example.domain.GetProductsUseCase
import com.example.domain.ProductRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideUseCase(repo:ProductRepo):GetProductsUseCase{
        return GetProductsUseCase(repo)
    }
}