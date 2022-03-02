package com.erik.firstjetpack.domain.use_case.get_coin

import com.erik.firstjetpack.common.Resource
import com.erik.firstjetpack.data.remote.data_transfer_object.toCoinDetail
import com.erik.firstjetpack.domain.model.CoinDetail
import com.erik.firstjetpack.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading<CoinDetail>())
            val coin = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success<CoinDetail>(coin))
        } catch(e: HttpException) {
            emit(Resource.Error<CoinDetail>(e.localizedMessage ?: "Terjadi Kesalahan"))
        } catch(e: IOException) {
            emit(Resource.Error<CoinDetail>("Tidak Dapat Tersambung Server"))
        }
    }
}