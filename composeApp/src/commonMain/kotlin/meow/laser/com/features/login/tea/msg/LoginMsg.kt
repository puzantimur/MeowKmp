package meow.laser.com.features.login.tea.msg

internal sealed class LoginMsg {
    
    data object StartAuth : LoginMsg()

    data class OnInputPhone(
        val phone: String,
    ) : LoginMsg()

    data class OnInputPassword(
        val pass: String,
    ) : LoginMsg()

    data class OnConfirmClicked(
        val phone: String,
        val pass: String,
    ) : LoginMsg()

    data object OnCloseClick : LoginMsg()


}

internal sealed class LoginDomainMsg: LoginMsg() {


}