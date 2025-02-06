package com.modularize.domain.model

data class User(
    val id: Int,
    val firstname: String,
    val lastname: String,
    var serverId: Int?,
)
