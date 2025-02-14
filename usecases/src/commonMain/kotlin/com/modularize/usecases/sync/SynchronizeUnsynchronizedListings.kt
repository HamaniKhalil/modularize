package com.modularize.usecases.sync

import com.modularize.domain.Repository
import com.modularize.usecases.BaseUseCase
import com.modularize.usecases.sync.SynchronizeUnsynchronizedListings.SynchronizeResult.Error
import com.modularize.usecases.sync.SynchronizeUnsynchronizedListings.SynchronizeResult.Success

class SynchronizeUnsynchronizedListings(private val repository: Repository): BaseUseCase(repository) {

    sealed class SynchronizeResult {

        data object Success : SynchronizeResult()
        data object Error : SynchronizeResult()

    }

    operator fun invoke(): SynchronizeResult =
        try {
            repository.synchronizeUnsynchronizedListings()
            Success
        } catch (e: Exception) {
            Error
        }
}