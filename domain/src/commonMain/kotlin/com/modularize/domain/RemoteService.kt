package com.modularize.domain

import com.modularize.domain.model.Currency
import com.modularize.domain.model.Post
import com.modularize.domain.model.Price
import com.modularize.domain.model.User

interface RemoteService {

    // ==== User ====
    fun getUser(remoteId: Int): User

    // ==== Price ====
    fun getPrice(remoteId: Int): Price

    fun updatePriceValue(remoteId: Int, value: Double)

    // ==== Currency ====
    fun getCurrency(remoteId: Int): Currency

    // ==== Post ====
    fun createPost(post: Post)

    fun updatePostInformation(postId: Int, title: String, description: String)

}