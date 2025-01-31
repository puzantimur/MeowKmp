package meow.laser.com.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import meow.laser.com.core.tea.StateHandler

abstract class BaseViewModel<in State : Any, Msg : Any, out UiState: Any>(
    private val stateHandler: StateHandler<State, Msg>,
) : ViewModel() {
    
    abstract val uiState: Flow<UiState>
           
    fun sendMsg(msg: Msg) {
        viewModelScope.launch {
            stateHandler.handle(msg)
        }
    }
    
    abstract fun mapState(state: State): UiState
    
}