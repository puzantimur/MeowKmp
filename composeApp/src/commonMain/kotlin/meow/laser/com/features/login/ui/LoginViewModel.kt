package meow.laser.com.features.login.ui

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filterIsInstance
import kotlinx.coroutines.flow.map
import meow.laser.com.base.BaseViewModel
import meow.laser.com.features.login.LoginState
import meow.laser.com.features.login.tea.handlers.LoginStateHandler
import meow.laser.com.features.login.tea.msg.LoginMsg

internal class LoginViewModel(
    private val stateHandler: LoginStateHandler
) : BaseViewModel<LoginState, LoginMsg, LoginUiState>(stateHandler) {
    
    override val uiState: Flow<LoginUiState>
        get() = stateHandler
            .stateFlow
            .filterIsInstance<LoginState>()
            .map(::mapState)

    override fun mapState(state: LoginState): LoginUiState {
        return LoginUiState()
    }
}

data class LoginUiState(
    val phoneNumber: String = "",
    val password: String = "",
)