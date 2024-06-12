package meow.laser.com.features.login

internal sealed interface LoginState {
    data object None: LoginState
    sealed interface Progress: LoginState
}