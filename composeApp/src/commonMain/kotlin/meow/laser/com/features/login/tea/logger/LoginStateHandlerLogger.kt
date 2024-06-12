package meow.laser.com.features.login.tea.logger

import meow.laser.com.tea.StateHandlerImpl
import meow.laser.com.tea.StateHandlerLogger
import org.koin.core.logger.Logger

internal class LoginStateHandlerLogger(
    private val logger: Logger,
) : StateHandlerLogger {
    override fun log(message: String) {
        
    }
    
    companion object {
        private const val LOGIN_TAG = "LOGIN_TAG"
    }

}