package com.erik.firstjetpack.domain.use_case.get_coins

import com.erik.firstjetpack.common.Resource
import com.erik.firstjetpack.data.remote.data_transfer_object.toCoin
import com.erik.firstjetpack.domain.model.Coin
import com.erik.firstjetpack.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading<List<Coin>>())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success<List<Coin>>(coins))
        } catch(e: HttpException) {
            emit(Resource.Error<List<Coin>>(e.localizedMessage ?: "Terjadi Kesalahan"))
        } catch(e: IOException) {
            emit(Resource.Error<List<Coin>>("Tidak Dapat Tersambung Server"))
        }
    }
}