package meow.laser.com.features.login.ui

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filterIsInstance
import kotlinx.coroutines.flow.map
import meow.laser.com.base.BaseViewModel
import meow.laser.com.features.login.tea.state.LoginState
import meow.laser.com.features.login.tea.handlers.LoginStateHandler
import meow.laser.com.features.login.tea.msg.LoginMsg
import meow.laser.com.features.login.tea.state.LoginState.Progress.InputDataState

internal class LoginViewModel(
    private val stateHandler: LoginStateHandler
) : BaseViewModel<LoginState, LoginMsg, LoginUiState>(stateHandler) {
    
    init {
        sendMsg(LoginMsg.StartAuth)
    }

    override val uiState: Flow<LoginUiState>
        get() = stateHandler
            .stateFlow
            .filterIsInstance<LoginState>()
            .map(::mapState)

    override fun mapState(state: LoginState): LoginUiState {
        return when(state) {
            LoginState.None -> LoginUiState()
            is InputDataState -> LoginUiState(
                password = state.password,
                phoneNumber = state.phone,
                isLoading = state.step == InputDataState.Step.Loading
            )
            is LoginState.Cancel -> LoginUiState()
        }
    }
}

sealed class UiEffect {
    data object CloseLoginFlow : UiEffect()
}

data class LoginUiState(
    val phoneNumber: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
)