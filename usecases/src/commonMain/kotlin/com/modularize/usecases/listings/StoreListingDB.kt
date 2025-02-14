package com.modularize.usecases.listings

import com.modularize.domain.Repository
import com.modularize.domain.model.Listing
import com.modularize.usecases.BaseUseCase
import com.modularize.usecases.listings.StoreListingDB.StoreListingDB.Error
import com.modularize.usecases.listings.StoreListingDB.StoreListingDB.Success
import kotlinx.datetime.Clock

class StoreListingDB(repository: Repository) : BaseUseCase(repository) {

    sealed class StoreListingDB {
        data object Success : StoreListingDB()

        data object Error : StoreListingDB()
    }

    operator fun invoke(listing: Listing): StoreListingDB =
        try {
            if (db.listingExists(listing.id)) {
                db.createListing(listing)
            } else {
                db.updateListingInformation(
                    listingId = listing.id,
                    title = listing.title,
                    description = listing.description,
                    updatedAt = Clock.System.now(),
                )
                db.updateListingSyncStatus(listing.id, true)
            }
            Success
        } catch (e: Exception) {
            Error
        }
}