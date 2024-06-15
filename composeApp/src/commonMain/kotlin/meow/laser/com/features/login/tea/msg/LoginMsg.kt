package meow.laser.com.features.login.tea.msg

internal sealed class LoginMsg {
    
    data class OnInputPhone(
        val phone: String,
    ) : LoginMsg()

    data class OnInputPassword(
        val pass: String,
    ) : LoginMsg()

}