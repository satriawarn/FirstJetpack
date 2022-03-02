package com.erik.firstjetpack.presentation.coin_list

import com.erik.firstjetpack.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)
