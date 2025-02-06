package com.modularize.domain.model

import kotlinx.datetime.Instant

data class Post(
    val id: Int,
    val title: String,
    val description: String,
    val price: Price,
    var createdAt: Instant,
    var updatedAt: Instant?,
    var serverId: Int?,
    val needSync: Boolean,
)
