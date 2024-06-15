package meow.laser.com.features.login.di

import org.koin.core.component.KoinComponent
import org.koin.core.qualifier.named

const val LOGIN_SCOPE_NAME = "Login_scope"

object LoginScopeHolder : KoinComponent {
    fun initScope() = getKoin().createScope(LOGIN_SCOPE_NAME, named(LOGIN_SCOPE_NAME))
    fun getScope() = getKoin().getScope(LOGIN_SCOPE_NAME)
}