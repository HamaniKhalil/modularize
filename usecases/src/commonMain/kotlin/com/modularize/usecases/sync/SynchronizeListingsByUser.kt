package com.modularize.usecases.sync

import com.modularize.domain.Repository
import com.modularize.domain.model.User
import com.modularize.usecases.BaseUseCase
import com.modularize.usecases.sync.SynchronizeListingsByUser.SynchronizeByUserResult.*
import kotlin.Error

class SynchronizeListingsByUser(private val repository: Repository): BaseUseCase(repository) {

    sealed class SynchronizeByUserResult {

        data object Success : SynchronizeByUserResult()
        data object Error : SynchronizeByUserResult()

    }

    operator fun invoke(user: User): SynchronizeByUserResult =
        try {
            repository.synchronizeByUser(user)
            Success
        } catch (e: Exception) {
            Error
        }
}