package com.erik.firstjetpack.domain.repository

import com.erik.firstjetpack.data.remote.data_transfer_object.CoinDetailDto
import com.erik.firstjetpack.data.remote.data_transfer_object.CoinDto

interface CoinRepository {
    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto
}