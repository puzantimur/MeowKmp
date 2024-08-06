package meow.laser.com.features.login.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import meow.laser.com.features.login.tea.msg.LoginMsg
import meow.laser.com.navigation.LocalNavHost
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI

@OptIn(KoinExperimentalAPI::class)
@Composable
internal fun LoginScreen(
    viewModel: LoginViewModel = koinViewModel<LoginViewModel>()
) {
    val externalNavHost = LocalNavHost.current
    val viewState by viewModel.uiState.collectAsState(LoginUiState())
    LoginView(
        callbacks = LoginViewCallback(
            onPhoneChanged = {
                viewModel.sendMsg(LoginMsg.OnInputPhone(it))
            },
            onPasswordChanged = {
                viewModel.sendMsg(LoginMsg.OnInputPassword(it))
            },
            onButtonLoginClicked = {
                viewModel.sendMsg(
                    LoginMsg.OnConfirmClicked(
                        phone = viewState.phoneNumber, pass = viewState.password
                    )
                )
            },
            onButtonCreateAccountClicked = {
//                externalNavHost.navigate(AppScreen.Main.title)
            },
            onButtonCloseClick = {
//                externalNavHost.navigate(AppScreen.Main.title)
            }
        ),
        uiState = viewState
    )
}