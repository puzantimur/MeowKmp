package meow.laser.com.features.homepage.tea.handlers

import meow.laser.com.features.homepage.tea.effect.HomepageEffect
import meow.laser.com.features.homepage.tea.logger.HomepageStateHandlerLogger
import meow.laser.com.features.homepage.tea.msg.HomepageMsg
import meow.laser.com.features.homepage.tea.reducer.HomepageReducer
import meow.laser.com.features.homepage.tea.state.HomepageState
import meow.laser.com.core.tea.StateHandler
import meow.laser.com.core.tea.StateHandlerImpl
import meow.laser.com.core.tea.StateHandlerScope

internal interface HomepageStateHandler : StateHandler<HomepageState, HomepageMsg>

internal class HomepageStateHandlerImpl(
    effectHandler: HomepageEffectHandler,
    reducer: HomepageReducer,
    logger: HomepageStateHandlerLogger,
    scope: StateHandlerScope,
) : HomepageStateHandler,
    StateHandlerImpl<HomepageState, HomepageMsg, HomepageEffect>(
        defaultState = HomepageState.None,
        scope = scope,
        reducer = reducer,
        effectHandler = effectHandler,
        logger = logger,
    )