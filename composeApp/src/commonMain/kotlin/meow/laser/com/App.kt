package meow.laser.com

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import meow.laser.com.features.detail.DetailScreen
import meow.laser.com.features.login.ui.LoginScreen
import meow.laser.com.features.splash.ui.SplashScreen
import meow.laser.com.navigation.AppScreen
import meow.laser.com.navigation.LocalNavHost
import meow.laser.com.navigation.main.MainScreen
import meow.laser.com.theme.MeowTheme
import org.koin.compose.KoinContext


@Composable
internal fun App() = MeowTheme {
    KoinContext {
        MeowApp()
    }
}

@Composable
internal fun MeowApp(
    navController: NavHostController = rememberNavController()
) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = backStackEntry?.destination?.route ?: AppScreen.Login

    CompositionLocalProvider(
        LocalNavHost provides navController
    ) {
        NavHost(
            navController = navController,
            startDestination = AppScreen.Splash.title
        ) {
            composable(route = AppScreen.Main.title) {
                MainScreen()
            }
            composable(route = AppScreen.Login.title) {
                LoginScreen()
            }
            composable(route = AppScreen.Detail.title) {
                DetailScreen()
            }
            composable(route = AppScreen.Splash.title) {
                SplashScreen(navController = navController)
            }
        }
    }

}

internal expect fun openUrl(url: String?)