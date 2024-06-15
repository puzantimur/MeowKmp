package meow.laser.com.features.login.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import meow.composeapp.generated.resources.JosefinSans_Bold
import meow.composeapp.generated.resources.Pacifico
import meow.composeapp.generated.resources.Res
import meow.composeapp.generated.resources.ic_main_logo
import meow.composeapp.generated.resources.login_view_button_confirm_text
import meow.composeapp.generated.resources.login_view_password_hint
import meow.composeapp.generated.resources.login_view_phone_number_hint
import meow.composeapp.generated.resources.login_view_sign_up
import meow.composeapp.generated.resources.login_view_welocome_back
import meow.laser.com.theme.MeowTheme
import meow.laser.com.theme.components.ButtonSize
import meow.laser.com.theme.components.MeowButton
import meow.laser.com.theme.components.MeowSpacer
import meow.laser.com.theme.components.MeowTextField
import meow.laser.com.theme.components.TextStyles
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.resources.vectorResource

@Composable
internal fun LoginView(
    callbacks: LoginViewCallback,
    uiState: LoginUiState,
) {

    Column(modifier = Modifier.fillMaxSize().padding(20.dp)) {

        MeowSpacer(24.dp)

        Box(modifier = Modifier.fillMaxWidth().height(72.dp)) {
            Text(
                modifier = Modifier.align(Alignment.Center),
                text = stringResource(Res.string.login_view_welocome_back),
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

        MeowTextField(
            onTextChanged = { callbacks.onPasswordChanged(it) },
            hint = stringResource(Res.string.login_view_password_hint),
            text = uiState.password,
        )

        MeowSpacer(18.dp)

        MeowButton(
            text = stringResource(Res.string.login_view_button_confirm_text),
            onButtonClick = {},
            buttonSize = ButtonSize.L,
        )

        Text(
            text = stringResource(Res.string.login_view_sign_up),
            modifier = Modifier
                .align(Alignment.End)
                .padding(end = 18.dp)
                .clickable {
                },
            style = TextStyles.subTitle,
            color = MeowTheme.colors.secondaryText,
            fontFamily = FontFamily(Font(Res.font.JosefinSans_Bold))
        )

        MeowSpacer(24.dp)

        Image(
            modifier = Modifier.size(250.dp).align(Alignment.CenterHorizontally),
            imageVector = vectorResource(Res.drawable.ic_main_logo),
            contentDescription = null
        )


    }

}

data class LoginViewCallback(
    val onPhoneChanged: (String) -> Unit,
    val onPasswordChanged: (String) -> Unit,
    val onButtonLoginClicked: () -> Unit,
    val onButtonCreateAccountClicked: () -> Unit,
)