package com.erik.firstjetpack.di

import com.erik.firstjetpack.common.Constants
import com.erik.firstjetpack.data.remote.APIClient
import com.erik.firstjetpack.data.repository.CoinRepositoryImpl
import com.erik.firstjetpack.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApiClient(): APIClient{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(APIClient::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(api: APIClient) : CoinRepository{
        return CoinRepositoryImpl(api)
    }
}