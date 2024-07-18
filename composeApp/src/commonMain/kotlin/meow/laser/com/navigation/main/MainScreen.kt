package meow.laser.com.navigation.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.rounded.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import meow.laser.com.features.homepage.HomepageScreen
import meow.laser.com.theme.MeowTheme

enum class MainScreens(val route: String) {
    HOME("home"),
    APPOINTMENTS("appointments"),
    PROFILE("profile"),
}

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val items = MainScreens.entries.toTypedArray()

    Box(modifier = Modifier.fillMaxSize()) {
        NavHost(
            navController = navController,
            modifier = Modifier.padding(bottom = 56.dp).fillMaxHeight(),
            startDestination = MainScreens.HOME.route
        ) {
            composable(MainScreens.HOME.route) {
                HomepageScreen()
            }
            composable(MainScreens.PROFILE.route) {

            }
            composable(MainScreens.APPOINTMENTS.route) {

            }
        }
        BottomNavigation(
            modifier = Modifier.align(Alignment.BottomStart).fillMaxWidth().height(56.dp),
            backgroundColor = MeowTheme.colors.surface
        ) {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentDestination = navBackStackEntry?.destination

            items.forEach { screen ->
                BottomNavigationItem(
                    icon = {
                        Icon(
                            imageVector = when (screen) {
                                MainScreens.HOME -> Icons.Filled.Home
                                MainScreens.APPOINTMENTS -> Icons.Rounded.Home
                                MainScreens.PROFILE -> Icons.Default.Home
                            },
                            contentDescription = screen.route,
                            tint = MeowTheme.colors.tertiaryContainer
                        )
                    },
                    selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                    label = {
                        Text(
                            text = when (screen) {
                                MainScreens.HOME -> MainScreens.HOME.name
                                MainScreens.APPOINTMENTS -> MainScreens.APPOINTMENTS.name
                                MainScreens.PROFILE -> MainScreens.PROFILE.name
                            },
                            color = MeowTheme.colors.onPrimary
                        )
                    },
                    onClick = {
                        navController.navigate(screen.route) {
                            popUpTo(navController.graph.findStartDestination().displayName) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    },
                    unselectedContentColor = MeowTheme.colors.primary,
                    selectedContentColor = MeowTheme.colors.tertiary
                )
            }
        }

    }

}