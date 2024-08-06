package meow.laser.com.features.homepage.di

import kotlinx.coroutines.cancel
import meow.laser.com.features.homepage.tea.handlers.HomepageEffectHandler
import meow.laser.com.features.homepage.tea.handlers.HomepageEffectHandlerImpl
import meow.laser.com.features.homepage.tea.handlers.HomepageStateHandler
import meow.laser.com.features.homepage.tea.handlers.HomepageStateHandlerImpl
import meow.laser.com.features.homepage.tea.logger.HomepageStateHandlerLogger
import meow.laser.com.features.homepage.tea.reducer.HomepageReducer
import meow.laser.com.features.homepage.ui.HomepageViewModel
import meow.laser.com.core.tea.StateHandlerLogger
import meow.laser.com.core.tea.StateHandlerScope
import meow.laser.com.features.homepage.data.HomepageRepositoryImpl
import meow.laser.com.features.homepage.domain.repo.HomepageRepository
import meow.laser.com.features.homepage.domain.usecase.FetchHomepageUseCase
import meow.laser.com.features.homepage.tea.reducer.HomepageDomainReducer
import org.koin.compose.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module
import org.koin.dsl.onClose

fun homepageModule() = module {
    single { StateHandlerScope() } onClose { it?.cancel() }
    factoryOf(::HomepageEffectHandlerImpl) bind HomepageEffectHandler::class
    singleOf(::HomepageStateHandlerImpl) bind HomepageStateHandler::class
    singleOf(::HomepageStateHandlerLogger) bind StateHandlerLogger::class
    factoryOf(::HomepageReducer)
    viewModelOf(::HomepageViewModel)
    singleOf(::HomepageRepositoryImpl) bind HomepageRepository::class
    factoryOf(::FetchHomepageUseCase)
    factoryOf(::HomepageDomainReducer)
}