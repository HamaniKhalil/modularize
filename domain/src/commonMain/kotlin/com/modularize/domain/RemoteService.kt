package com.modularize.domain

import com.modularize.domain.model.Authorization
import com.modularize.domain.model.Listing
import com.modularize.domain.model.User

interface RemoteService {

    // ==== Login ====
    fun login(email: String, password: String): Authorization?

    // ==== User ====
    fun getUser(remoteId: Int): User

    fun updateUserInformation(remoteId: Int, firstname: String, lastname: String): User

    // ==== Listing ====
    fun createListing(listing: Listing)

    fun updateListing(listing: Listing)

}