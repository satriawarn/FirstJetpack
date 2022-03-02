package com.erik.firstjetpack.presentation.coin_detail

import com.erik.firstjetpack.domain.model.Coin
import com.erik.firstjetpack.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
