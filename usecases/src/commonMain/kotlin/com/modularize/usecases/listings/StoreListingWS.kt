package com.modularize.usecases.listings

import com.modularize.domain.Repository
import com.modularize.domain.model.Listing
import com.modularize.usecases.BaseUseCase
import com.modularize.usecases.listings.StoreListingWS.StoreListingWS.Error
import com.modularize.usecases.listings.StoreListingWS.StoreListingWS.Success

class StoreListingWS(repository: Repository) : BaseUseCase(repository) {

    sealed class StoreListingWS {
        data object Success : StoreListingWS()

        data object Error : StoreListingWS()
    }

    operator fun invoke(listing: Listing): StoreListingWS =
        try {
            Success
        } catch (e: Exception) {
            Error
        }
}