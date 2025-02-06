package com.modularize.domain

import com.modularize.domain.model.Currency
import com.modularize.domain.model.Post
import com.modularize.domain.model.Price
import com.modularize.domain.model.User
import kotlinx.datetime.Instant

interface LocalService {

    // ==== User ====
    fun createUser(user: User)

    fun updateUserInformation(id: Int, firstname: String, lastname: String)

    // ==== Price ====
    fun createPrice(price: Price)

    fun updatePriceValue(id: Int, value: Double)

    fun updatePriceSyncStatus(id: Int, needSync: Boolean)

    // ==== Currency ====
    fun createCurrency(currency: Currency)

    fun updateCurrencySyncStatus(currencyId: Int, needSync: Boolean)

    // ==== Post ====
    fun createPost(post: Post)

    fun updatePostInformation(postId: Int, title: String, description: String, updatedAt: Instant)

    fun updatePostSyncStatus(postId: Int, needSync: Boolean)

}
