package meow.laser.com

import androidx.compose.runtime.*
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import meow.laser.com.features.catalog.CatalogScreen
import meow.laser.com.features.detail.DetailScreen
import meow.laser.com.features.login.di.loginModule
import meow.laser.com.features.login.ui.LoginScreen
import meow.laser.com.features.profile.ProfileScreen
import meow.laser.com.navigation.AppScreen
import meow.laser.com.navigation.LocalNavHost
import meow.laser.com.navigation.main.MainScreen
import meow.laser.com.theme.MeowTheme
import org.koin.compose.KoinApplication


@Composable
internal fun App() = MeowTheme {
    KoinApplication(application = {
        modules(
            loginModule(),

        )

    }) {

    }
    MeowApp()
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
            startDestination = AppScreen.Login.title
        ) {
            composable(route = AppScreen.Main.title) {
                MainScreen()
            }
            composable(route = AppScreen.Catalog.title) {
                CatalogScreen()
            }
            composable(route = AppScreen.Login.title) {
                LoginScreen()
            }
            composable(route = AppScreen.Profile.title) {
                ProfileScreen()
            }
            composable(route = AppScreen.Detail.title) {
                DetailScreen()
            }
        }
    }

}

internal expect fun openUrl(url: String?)