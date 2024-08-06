package meow.laser.com.core.tea

import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow

/**
 * [State] - состояние фичи, [Msg] - сообщения от пользователя или [EffectHandler],
 * сообщающее о необхимости выполнить следующее действие.
 */
interface StateHandler<out State : Any, Msg : Any> {
    val stateFlow: StateFlow<State>
    val msgFlow: SharedFlow<Msg>

    /** Обработать сообщение. */
    suspend fun handle(msg: Msg)
}