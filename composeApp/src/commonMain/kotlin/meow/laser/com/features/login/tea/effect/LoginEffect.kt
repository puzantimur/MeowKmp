package meow.laser.com.features.login

internal sealed class LoginEffect {
    
    data class ValidatePhone(
        val phone: String,
    ) : LoginEffect()

}