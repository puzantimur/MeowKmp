package meow.laser.com.features.homepage.data

import meow.laser.com.core.network.api.HomepageApi
import meow.laser.com.core.network.utils.Either
import meow.laser.com.core.network.utils.NetworkFailure
import meow.laser.com.core.network.utils.networkRequest
import meow.laser.com.core.network.models.HomepageResponse
import meow.laser.com.features.homepage.domain.repo.HomepageRepository

class HomepageRepositoryImpl(
    private val homepageApi: HomepageApi,
) : HomepageRepository {
    override suspend fun fetchHomepage(): Either<NetworkFailure, HomepageResponse> {
        return networkRequest {
            homepageApi.fetchHomepage()
        }
    }
}