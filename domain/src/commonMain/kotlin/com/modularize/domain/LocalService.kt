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

    fun getUser(id: Int): User

    fun createUser(user: User)

    fun updateUserInformation(id: Int, firstname: String, lastname: String)

    // ==== Listing ====
    fun listingExists(listingId: Int): Boolean

    fun createListing(listing: Listing)

    fun updateListingInformation(listingId: Int, title: String, description: String, updatedAt: Instant)

    fun updateListingSyncStatus(listingId: Int, needSync: Boolean)

    fun getUnsynchronizedListings(user: User): List<Listing>

    fun getListingsToSynchronize(): List<Listing>

}
