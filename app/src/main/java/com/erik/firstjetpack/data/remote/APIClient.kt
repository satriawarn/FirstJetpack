package com.erik.firstjetpack.data.remote

import com.erik.firstjetpack.data.remote.data_transfer_object.CoinDetailDto
import com.erik.firstjetpack.data.remote.data_transfer_object.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

interface APIClient {
    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinDto>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId: String): CoinDetailDto
}