package meow.laser.com.features.homepage.tea.handlers

import meow.laser.com.core.network.utils.NetworkFailure
import meow.laser.com.core.network.utils.fold
import meow.laser.com.features.homepage.tea.effect.HomepageEffect
import meow.laser.com.features.homepage.tea.msg.HomepageMsg
import meow.laser.com.core.tea.Dispatch
import meow.laser.com.core.tea.EffectHandler
import meow.laser.com.features.homepage.domain.usecase.FetchHomepageUseCase
import meow.laser.com.features.homepage.domain.models.HomepageData
import meow.laser.com.features.homepage.tea.msg.HomepageDomainMsg

internal interface HomepageEffectHandler : EffectHandler<HomepageEffect, HomepageMsg>

internal class HomepageEffectHandlerImpl(
    private val fetchHomepageUseCase: FetchHomepageUseCase,
) : HomepageEffectHandler {

    override suspend fun invoke(effect: HomepageEffect, dispatch: Dispatch<HomepageMsg>) {
        when (effect) {
            HomepageEffect.LoadHomepage -> handleLoadHomepage(dispatch)
        }
    }

    private suspend fun handleLoadHomepage(dispatch: Dispatch<HomepageMsg>) {
        fetchHomepageUseCase.invoke().fold(
            ifLeft = {
                dispatch(
                    HomepageDomainMsg.HomepageLoadFailed(
                        when (it) {
                            is NetworkFailure.HttpFailure -> {
                                it.message
                            }
                            is NetworkFailure.NoConnection -> {
                                "Check connection"
                            }
                        }
                    )
                )
            },
            ifRight = {
                dispatch(
                    HomepageDomainMsg.HomepageLoaded(
                        data = HomepageData(
                            womenTabData = it.womenTabData,
                            menTabData = it.menTabData,
                        )
                    )
                )
            }
        )
    }

}