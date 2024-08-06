package meow.laser.com.features.splash.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import meow.laser.com.navigation.AppScreen
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI

@OptIn(KoinExperimentalAPI::class)
@Composable
fun SplashScreen(
    viewModel: SplashViewModel = koinViewModel<SplashViewModel>(),
    navController: NavController,
) {
    val uiAction by viewModel.splashUiAction.collectAsState(null)

    viewModel.init()

    when (uiAction) {
        SplashUiAction.OpenHomepageScreen -> {
            navController.navigate(AppScreen.Main.title)
        }

        SplashUiAction.OpenLoginScreen -> navController.navigate(AppScreen.Login.title)
        null -> {}
    }


}