package com.example.productscleanarchit.di

import com.example.data.APIService
import com.example.data.ProductsRepoImp
import com.example.domain.ProductRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepoModule {
    @Provides
    fun provideRepo(apiService: APIService):ProductRepo{
        return ProductsRepoImp(apiService)
    }
}