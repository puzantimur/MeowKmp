package meow.laser.com.tea

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

abstract class StateHandlerImpl<State : Any, Msg : Any, Effect : Any>(
    defaultState: State,
    scope: StateHandlerScope,
    private val reducer: Reducer<State, Msg, Effect>,
    private val effectHandler: EffectHandler<Effect, Msg>,
    private val logger: StateHandlerLogger,
) : StateHandler<State, Msg> {
    override val stateFlow = MutableStateFlow(defaultState)

    /*
    Реплей нужен на случай когда сообщение придёт до подписки (launch).
    Такое случается, корутины могут стартовать с пробуксовкой.
    */
    override val msgFlow = MutableSharedFlow<Msg>(replay = 1)

    private val name = this::class.simpleName
    
    init {
        scope.launch {
            msgFlow.collect { msg ->
                logger.log("======================================================")
                logger.log("$name, Input msg: $msg")
                val (state, effects) = reducer(stateFlow.value, msg)
                logger.log("$name, Output state: $state, effects: $effects")
                stateFlow.emit(state)
                effects.forEach { effect -> launch { effectHandler(effect, ::handle) } }
            }
        }
    }

    override suspend fun handle(msg: Msg) {
        msgFlow.emit(msg)
    }
}