package meow.laser.com.features.login.tea.reducer

import meow.laser.com.features.login.LoginEffect
import meow.laser.com.features.login.LoginState
import meow.laser.com.features.login.tea.msg.LoginMsg
import meow.laser.com.tea.Reducer

internal class LoginReducer : Reducer<LoginState, LoginMsg, LoginEffect> {
    
    override fun invoke(state: LoginState, msg: LoginMsg): Pair<LoginState, Set<LoginEffect>> {
        TODO("Not yet implemented")
    }

}