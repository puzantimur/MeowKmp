package meow.laser.com.features.login.tea.reducer

import meow.laser.com.features.login.LoginEffect
import meow.laser.com.features.login.tea.state.LoginState
import meow.laser.com.features.login.tea.msg.LoginMsg
import meow.laser.com.tea.Reducer

internal class LoginReducer : Reducer<LoginState, LoginMsg, LoginEffect> {

    override fun invoke(state: LoginState, msg: LoginMsg): Pair<LoginState, Set<LoginEffect>> {
        return when (state) {
            LoginState.None -> LoginState.Progress.InputDataState(
                phone = "",
                password = "",
                step = LoginState.Progress.InputDataState.Step.WaitingActions(null)
            ) to emptySet()

            is LoginState.Progress.InputDataState -> {
                when (msg) {
                    is LoginMsg.OnInputPassword -> reduce(state, msg)
                    is LoginMsg.OnInputPhone -> reduce(state, msg)
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

}