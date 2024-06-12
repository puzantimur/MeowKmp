package meow.laser.com.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.Flow
import meow.laser.com.tea.StateHandler

abstract class BaseViewModel<in State : Any, Msg : Any, out UiState: Any>(
    private val stateHandler: StateHandler<State, Msg>,
) : ViewModel() {
    
    abstract val uiState: Flow<UiState>
           
    suspend fun sendMsg(msg: Msg) {
        stateHandler.handle(msg)
    }
    
    abstract fun mapState(state: State): UiState
    
}