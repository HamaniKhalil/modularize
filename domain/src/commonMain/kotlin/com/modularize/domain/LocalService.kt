package com.modularize.domain

import com.modularize.domain.model.Authorization
import com.modularize.domain.model.Listing
import com.modularize.domain.model.User
import kotlinx.datetime.Instant

interface LocalService {

    // ==== Login ====
    fun storeTokens(authorization: Authorization)

    // ==== User ====
    fun userExists(remoteId: Int): Boolean

    fun createUser(user: User)

    fun updateUserInformation(id: Int, firstname: String, lastname: String)

    // ==== Listing ====
    fun createListing(listing: Listing)

    fun updateListingInformation(listingId: Int, title: String, description: String, updatedAt: Instant)

    fun updateListingSyncStatus(listingId: Int, needSync: Boolean)

}
