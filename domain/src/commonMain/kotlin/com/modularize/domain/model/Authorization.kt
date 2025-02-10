package com.modularize.domain.model

data class Authorization(
    val accessToken: String,
    val refreshToken: String,
    val remoteUserId: Int,
)
