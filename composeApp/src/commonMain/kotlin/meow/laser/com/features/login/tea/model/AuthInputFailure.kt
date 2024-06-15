package meow.laser.com.features.login.tea.model

import meow.laser.com.base.network.NetworkFailure

sealed class AuthInputFailure {
    data class Validation(val failure: LoginValidationFailure) : AuthInputFailure()
    /** Пользователь ввёл логин, а он у нас не зарегистрирован. */
    
    data class Network(val networkFailure: NetworkFailure) : AuthInputFailure()
}

enum class LoginValidationFailure {
    EmptyPhone,
    EmptyPassword,
    WrongLogin,
    WrongPassword,
}