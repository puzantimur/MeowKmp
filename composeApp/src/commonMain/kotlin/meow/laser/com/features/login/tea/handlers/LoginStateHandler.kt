package meow.laser.com.features.login.tea.handlers

import meow.laser.com.features.login.LoginEffect
import meow.laser.com.features.login.tea.state.LoginState
import meow.laser.com.features.login.tea.logger.LoginStateHandlerLogger
import meow.laser.com.features.login.tea.msg.LoginMsg
import meow.laser.com.features.login.tea.reducer.LoginReducer
import meow.laser.com.tea.StateHandler
import meow.laser.com.tea.StateHandlerImpl
import meow.laser.com.tea.StateHandlerScope

internal interface LoginStateHandler : StateHandler<LoginState, LoginMsg>

internal class LoginStateHandlerImpl(
    effectHandler: LoginEffectHandler,
    reducer: LoginReducer,
    logger: LoginStateHandlerLogger,
    scope: StateHandlerScope,
) : LoginStateHandler,
    StateHandlerImpl<LoginState, LoginMsg, LoginEffect>(
        defaultState = LoginState.None,
        scope = scope,
        reducer = reducer,
        effectHandler = effectHandler,
        logger = logger,
    )