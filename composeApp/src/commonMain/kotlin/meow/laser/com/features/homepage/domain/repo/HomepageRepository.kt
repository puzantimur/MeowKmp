package meow.laser.com.features.homepage.domain.repo

import meow.laser.com.core.network.utils.Either
import meow.laser.com.core.network.utils.NetworkFailure
import meow.laser.com.core.network.models.HomepageResponse

interface HomepageRepository {
    suspend fun fetchHomepage() : Either<NetworkFailure, HomepageResponse>
}