package com.modularize.domain.model

import kotlinx.datetime.Instant

data class Listing(
    val id: Int,
    val author: User,
    val title: String,
    val description: String,
    val price: Double,
    var updatedAt: Instant?,
    var serverId: Int = -1,
    val needSync: Boolean,
) {

    fun isRemotelyStored(): Boolean = serverId == NO_ID
    fun isNotRemotelyStored(): Boolean = !isRemotelyStored()

    companion object {
        const val NO_ID = -1  // Value when no storage id available
    }
}
