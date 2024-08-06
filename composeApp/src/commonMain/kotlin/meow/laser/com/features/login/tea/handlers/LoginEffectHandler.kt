package meow.laser.com.features.login.tea.handlers

import meow.laser.com.features.login.LoginEffect
import meow.laser.com.features.login.tea.msg.LoginMsg
import meow.laser.com.core.tea.Dispatch
import meow.laser.com.core.tea.EffectHandler

internal interface LoginEffectHandler : EffectHandler<LoginEffect, LoginMsg>

internal class LoginEffectHandlerImpl : LoginEffectHandler {
    
    override suspend fun invoke(effect: LoginEffect, dispatch: Dispatch<LoginMsg>) {
        when(effect) {
            is LoginEffect.ValidatePhone -> {
                

            }

            else -> {}
        }
        
    }

}