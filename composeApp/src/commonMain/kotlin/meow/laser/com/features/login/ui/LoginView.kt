package meow.laser.com.features.login.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import meow.composeapp.generated.resources.*
import meow.composeapp.generated.resources.Res
import meow.composeapp.generated.resources.login_view_create_account_main_title
import meow.composeapp.generated.resources.login_view_password_hint
import meow.composeapp.generated.resources.login_view_phone_number_hint
import meow.laser.com.theme.MeowTheme
import meow.laser.com.theme.components.*
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.stringResource

@Composable
internal fun LoginView(
    callbacks: LoginViewCallback = LoginViewCallback({}, {}, {}, {}),
    uiState: LoginUiState = LoginUiState(),
) {
    
    Column(modifier = Modifier.fillMaxSize().padding(20.dp)) {

        MeowSpacer(24.dp)

        Box(modifier = Modifier.fillMaxWidth().height(72.dp)) {
            Text(
                modifier = Modifier.align(Alignment.Center),
                text = stringResource(Res.string.app_name),
                color = MeowTheme.colors.primaryText,
                style = TextStyles.mainTitle,
                fontFamily = FontFamily(Font(Res.font.Pacifico))
            )
        }

        MeowSpacer(12.dp)

        MeowTextField(
            onTextChanged = { callbacks.onPhoneChanged(it) },
            hint = stringResource(Res.string.login_view_phone_number_hint),
            text = uiState.phoneNumber,
        )

        MeowSpacer(6.dp)

        MeowTextField(
            onTextChanged = { callbacks.onPasswordChanged(it) },
            hint = stringResource(Res.string.login_view_password_hint),
            text = uiState.password,
        )

        MeowSpacer(12.dp)
        
        MeowButton(
            text = stringResource(Res.string.login_view_button_confirm_text),
            onButtonClick = {},
            buttonSize = ButtonSize.L,
        )
    }

}

data class LoginViewCallback(
    val onPhoneChanged: (String) -> Unit,
    val onPasswordChanged: (String) -> Unit,
    val onButtonLoginClicked: () -> Unit,
    val onButtonCreateAccountClicked: () -> Unit,
)