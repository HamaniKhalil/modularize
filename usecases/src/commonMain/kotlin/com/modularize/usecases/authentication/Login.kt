package com.modularize.usecases.authentication

import com.modularize.domain.Repository
import com.modularize.usecases.BaseUseCase
import com.modularize.usecases.authentication.Login.LoginResult.Error
import com.modularize.usecases.authentication.Login.LoginResult.Success

class Login(repository: Repository) : BaseUseCase(repository) {

    sealed class LoginResult {

        data object Success : LoginResult()

        data object Error : LoginResult()
    }


    operator fun invoke(email: String, password: String): LoginResult =
        try {
            server.login(email, password)
            Success
        } catch (e: Exception) {
            Error
        }
}