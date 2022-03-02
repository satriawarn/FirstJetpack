package com.erik.firstjetpack.data.repository

import com.erik.firstjetpack.data.remote.APIClient
import com.erik.firstjetpack.data.remote.data_transfer_object.CoinDetailDto
import com.erik.firstjetpack.data.remote.data_transfer_object.CoinDto
import com.erik.firstjetpack.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: APIClient
) : CoinRepository {
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }
}