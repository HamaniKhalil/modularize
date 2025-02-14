package com.modularize.usecases

import com.modularize.domain.LocalService
import com.modularize.domain.RemoteService
import com.modularize.domain.Repository

abstract class BaseUseCase(repository: Repository) {

    val db: LocalService = repository.localService
    val server: RemoteService = repository.remoteService

}