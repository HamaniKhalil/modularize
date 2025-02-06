package com.modularize.domain.model

data class Price(
    val id: Int,
    val value: Double,
    val currency: Currency,
    var needSync: Boolean,
)