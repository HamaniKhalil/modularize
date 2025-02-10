package com.modularize.domain

import com.modularize.domain.exceptions.UnauthorizedLoginException
import com.modularize.domain.model.Listing
import com.modularize.domain.model.Listing.Companion.NO_ID
import kotlinx.datetime.Clock

class Repository(
    val localService: LocalService,
    val remoteService: RemoteService,
) {
    // ==== Login ===
    fun loginAndCreateUserIfNotExists(email: String, password: String) {
        val authorization =
            remoteService.login(email, password) ?: throw UnauthorizedLoginException()
        localService.storeTokens(authorization)

        val user = remoteService.getUser(authorization.remoteUserId)

        if (localService.userExists(authorization.remoteUserId))
            localService.createUser(user)
    }


    // ==== User ====

    fun updateUserDB(userId: Int, firstname: String, lastname: String) {
        localService.updateUserInformation(userId, firstname, lastname)
    }

    fun updateUserWS(remoteUserId: Int, firstname: String, lastname: String) {
        remoteService.updateUserInformation(remoteUserId, firstname, lastname)
    }

    // ==== Listing ====
    fun storeListingDB(listing: Listing) {
        val updatedAt = Clock.System.now()
        localService.updateListingInformation(listing.id, listing.title, listing.description, updatedAt)
        localService.updateListingSyncStatus(listing.id, true)
    }

    fun storeListingWS(listing: Listing) {
        if(listing.isRemotelyStored()) {
            remoteService.updateListing(listing)
        } else {
            remoteService.createListing(listing)
        }
    }

    fun synchronize(listing: Listing) {
        when {
            listing.serverId == NO_ID -> {
                remoteService.createListing(listing)
            }

            listing.needSync -> {
                if (listing.isRemotelyStored())
                    remoteService.updateListing(listing)
                else {
                    remoteService.createListing(listing)
                    localService.createListing(listing)
                }
            }
        }
        localService.updateListingSyncStatus(listing.id, false)
    }

    // ==== Review ====

}