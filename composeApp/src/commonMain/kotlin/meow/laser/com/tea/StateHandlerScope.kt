package meow.laser.com.tea

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

/**
 * Скоуп корутин который должен быть отменён вместе со смертью StateHandler.
* Не хочется использовать просто [CoroutineScope] чтобы случайно не использовать не тот скоуп.
*/
interface StateHandlerScope : CoroutineScope

/** Копия функции-билдера [CoroutineScope]. */
fun StateHandlerScope(context: CoroutineContext = Dispatchers.IO): StateHandlerScope =
     StateHandlerScopeImpl(if (context[Job] != null) context else context + Job())

/**
* Реализация интерфейса.
*/
internal class StateHandlerScopeImpl(override val coroutineContext: CoroutineContext) : StateHandlerScope {
    override fun toString(): String = "StateHandlerScope(coroutineContext=$coroutineContext)"
}