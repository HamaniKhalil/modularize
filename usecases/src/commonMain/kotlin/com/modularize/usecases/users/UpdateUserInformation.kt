package com.modularize.usecases.users

import com.modularize.domain.Repository
import com.modularize.domain.model.User
import com.modularize.usecases.BaseUseCase
import com.modularize.usecases.users.UpdateUserInformation.StoreUserInformationResult.Error
import com.modularize.usecases.users.UpdateUserInformation.StoreUserInformationResult.Success

class UpdateUserInformation(repository: Repository) : BaseUseCase(repository) {

    sealed class StoreUserInformationResult {
        data object Success : StoreUserInformationResult()
        data object Error : StoreUserInformationResult()
    }

    operator fun invoke(user: User): StoreUserInformationResult =
        try {
            with(user) {
                db.updateUserInformation(id, firstname, lastname)
                server.updateUserInformation(serverId, firstname, lastname)
            }
            Success
        } catch (e: Exception) {
            Error
        }
}