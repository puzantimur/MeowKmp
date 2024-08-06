package meow.laser.com.features.login.tea.reducer

import meow.laser.com.features.login.LoginEffect
import meow.laser.com.features.login.tea.state.LoginState
import meow.laser.com.features.login.tea.msg.LoginMsg
import meow.laser.com.core.tea.Reducer

internal class LoginReducer : Reducer<LoginState, LoginMsg, LoginEffect> {

    override fun invoke(state: LoginState, msg: LoginMsg): Pair<LoginState, Set<LoginEffect>> {
        return when (msg) {

            LoginMsg.OnCloseClick -> LoginState.Cancel to emptySet()

            is LoginMsg.OnConfirmClicked -> if (state is LoginState.Progress.InputDataState) {
                reduce(state, msg)
            } else state to emptySet()

            is LoginMsg.OnInputPassword -> if (state is LoginState.Progress.InputDataState) {
                reduce(state, msg)
            } else state to emptySet()

            is LoginMsg.OnInputPhone -> if (state is LoginState.Progress.InputDataState) {
                reduce(state, msg)
            } else state to emptySet()

            LoginMsg.StartAuth -> {
                when (state) {
                    LoginState.Cancel -> state to emptySet()
                    LoginState.None -> LoginState.Progress.InputDataState(
                        phone = "",
                        password = "",
                        step = LoginState.Progress.InputDataState.Step.WaitingActions(null)
                    ) to emptySet()

                    is LoginState.Progress.InputDataState -> state to emptySet()
                }
            }
        }
    }


    private fun reduce(
        state: LoginState.Progress.InputDataState,
        msg: LoginMsg.OnInputPassword
    ): Pair<LoginState, Set<LoginEffect>> = state.copy(password = msg.pass) to emptySet()

    private fun reduce(
        state: LoginState.Progress.InputDataState,
        msg: LoginMsg.OnInputPhone
    ): Pair<LoginState, Set<LoginEffect>> = state.copy(phone = msg.phone) to emptySet()

    private fun reduce(
        state: LoginState.Progress.InputDataState,
        msg: LoginMsg.OnConfirmClicked
    ): Pair<LoginState, Set<LoginEffect>> =
        state.copy(step = LoginState.Progress.InputDataState.Step.Loading) to emptySet()

}