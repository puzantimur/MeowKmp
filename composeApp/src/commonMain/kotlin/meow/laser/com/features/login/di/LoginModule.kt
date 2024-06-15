package meow.laser.com.features.login.di

import kotlinx.coroutines.cancel
import meow.laser.com.features.login.tea.handlers.LoginEffectHandler
import meow.laser.com.features.login.tea.handlers.LoginEffectHandlerImpl
import meow.laser.com.features.login.tea.handlers.LoginStateHandler
import meow.laser.com.features.login.tea.handlers.LoginStateHandlerImpl
import meow.laser.com.features.login.tea.logger.LoginStateHandlerLogger
import meow.laser.com.features.login.tea.reducer.LoginReducer
import meow.laser.com.features.login.ui.LoginViewModel
import meow.laser.com.tea.StateHandlerLogger
import meow.laser.com.tea.StateHandlerScope
import org.koin.compose.viewmodel.dsl.viewModel
import org.koin.dsl.bind
import org.koin.dsl.module
import org.koin.dsl.onClose

fun loginModule() = module {
    
        single { StateHandlerScope() } onClose { it?.cancel() }

        factory {
            LoginEffectHandlerImpl()
        } bind LoginEffectHandler::class
        
        single {
            LoginStateHandlerLogger(logger)
        } bind StateHandlerLogger::class
        
        factory {
            LoginReducer()
        }

        single {
            LoginStateHandlerImpl(
                effectHandler = get(),
                reducer = get(),
                logger = get(),
                scope = get(),
            )
        } bind LoginStateHandler::class
        
        viewModel {
            LoginViewModel(
                stateHandler = get()
            )
        }

    


}