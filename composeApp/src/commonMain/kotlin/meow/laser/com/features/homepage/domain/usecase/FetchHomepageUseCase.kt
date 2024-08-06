package meow.laser.com.features.homepage.domain.usecase

import meow.laser.com.core.network.utils.Either
import meow.laser.com.core.network.utils.NetworkFailure
import meow.laser.com.core.network.utils.fold
import meow.laser.com.features.homepage.data.mapToDomain
import meow.laser.com.features.homepage.domain.models.HomepageData
import meow.laser.com.features.homepage.domain.repo.HomepageRepository

internal class FetchHomepageUseCase(
    private val homepageRepository: HomepageRepository,
) {
    suspend operator fun invoke(): Either<NetworkFailure, HomepageData> {
        return homepageRepository.fetchHomepage().fold(
            ifLeft = {
                Either.Left(it)
            },
            ifRight = {
                Either.Right(it.mapToDomain())
            }
        )
    }

}