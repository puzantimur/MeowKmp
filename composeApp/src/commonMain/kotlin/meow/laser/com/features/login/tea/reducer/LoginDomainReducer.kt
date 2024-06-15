package meow.laser.com.features.login.tea.reducer

import meow.laser.com.features.login.LoginEffect
import meow.laser.com.features.login.tea.state.LoginState
import meow.laser.com.features.login.tea.msg.LoginMsg
import meow.laser.com.tea.Reducer

internal class LoginDomainReducer : Reducer<LoginState, LoginMsg, LoginEffect> {
    
    override fun invoke(state: LoginState, msg: LoginMsg): Pair<LoginState, Set<LoginEffect>> {
        return LoginState.None to emptySet()
    }

}