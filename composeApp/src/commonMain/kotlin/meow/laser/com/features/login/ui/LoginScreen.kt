package meow.laser.com.features.login

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import meow.laser.com.features.login.ui.LoginUiState
import meow.laser.com.features.login.ui.LoginView
import meow.laser.com.features.login.ui.LoginViewModel
import meow.laser.com.navigation.LocalNavHost
import org.koin.core.context.stopKoin

@Composable
internal fun LoginScreen(
//    viewModel: LoginViewMode
) {
    val externalNavHost = LocalNavHost.current
//    val viewState by viewModel.uiState.collectAsState(LoginUiState())


    LoginView()
}