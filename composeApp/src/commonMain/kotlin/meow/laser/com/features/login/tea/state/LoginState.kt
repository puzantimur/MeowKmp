package meow.laser.com.features.login.tea.state

import meow.laser.com.features.login.tea.model.AuthInputFailure

internal sealed interface LoginState {
    data object None: LoginState
    sealed class Progress: LoginState {
        data class InputDataState(
            val phone: String,
            val password: String,
            val step: Step,
        ) : Progress() {

            sealed class Step {
                /** Ожидаем действия пользователя. */
                data class WaitingActions(val failure: AuthInputFailure?) : Step()

                /** Идёт какой-то запрос на бэкенд. */
                data object Loading : Step()
            }
        }
    }
}