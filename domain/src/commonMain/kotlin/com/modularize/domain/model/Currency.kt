package com.modularize.domain.model

data class Currency(
    val id: Int,
    val code: String,
    var needSync: Boolean,
    var serverId: Int?
)
