package com.modularize.usecases.users

import com.modularize.domain.Repository
import com.modularize.domain.model.User
import com.modularize.usecases.BaseUseCase
import com.modularize.usecases.users.GetUser.GetUserResult.Error
import com.modularize.usecases.users.GetUser.GetUserResult.Success

class GetUser(repository: Repository): BaseUseCase(repository) {

    sealed class GetUserResult {
        data class Success(val user: User) : GetUserResult()
        data object Error : GetUserResult()
    }

    operator fun invoke(remoteId: Int): GetUserResult =
        try {
            Success(db.getUser(remoteId))
        } catch (e: Exception) {
            Error
        }
}