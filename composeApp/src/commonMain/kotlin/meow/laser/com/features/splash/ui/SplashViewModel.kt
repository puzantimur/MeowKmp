package meow.laser.com.features.splash.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import meow.laser.com.features.login.domain.usecase.IsUserAuthorizedUseCase
import meow.laser.com.features.splash.di.SplashScreenModuleController
import org.koin.core.Koin

class SplashViewModel(
    private val isUserAuthorizedUseCase: IsUserAuthorizedUseCase,
): ViewModel() {

    private val _splashUiAction = MutableSharedFlow<SplashUiAction>()
    val splashUiAction: Flow<SplashUiAction> = _splashUiAction.asSharedFlow()

    fun init() {
        viewModelScope.launch {
            isUserAuthorized()
        }
    }

    private suspend fun isUserAuthorized() {
        if (isUserAuthorizedUseCase.invoke()) {
            _splashUiAction.emit(SplashUiAction.OpenHomepageScreen)
        } else {
            _splashUiAction.emit(SplashUiAction.OpenLoginScreen)
        }
    }

    override fun onCleared() {
        SplashScreenModuleController.unloadModule(Koin())
        super.onCleared()
    }

}

sealed class SplashUiAction {
    data object OpenLoginScreen : SplashUiAction()
    data object OpenHomepageScreen : SplashUiAction()
}


