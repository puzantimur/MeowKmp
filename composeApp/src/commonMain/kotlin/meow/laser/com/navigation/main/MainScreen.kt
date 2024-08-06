package meow.laser.com.navigation.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import meow.composeapp.generated.resources.FjordOne_Regular
import meow.composeapp.generated.resources.Res
import meow.composeapp.generated.resources.ic_laser_store
import meow.composeapp.generated.resources.ic_my_booking
import meow.composeapp.generated.resources.ic_profile
import meow.laser.com.features.homepage.ui.HomepageScreen
import meow.laser.com.navigation.main.utils.mapForTitle
import meow.laser.com.theme.MeowTheme
import meow.laser.com.theme.components.TextStyles
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.resources.vectorResource

enum class MainScreens(val route: String) {
    HOME("home"),
    APPOINTMENTS("appointments"),
    PROFILE("profile"),
}

@Composable
fun MainScreen() {
    val rootNavController = rememberNavController()
    val navBackStackEntry by rootNavController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    val items = MainScreens.entries

    Scaffold(
        backgroundColor = MeowTheme.colors.surfaceBright,
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            BottomNavigation(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                backgroundColor = MeowTheme.colors.surfaceContainerLow
            ) {

                items.forEach { screen ->
                    val isSelected =
                        currentDestination?.hierarchy?.any { it.route == screen.route } == true
                    BottomNavigationItem(
                        icon = {
                            Image(
                                modifier = Modifier
                                    .size(24.dp),
                                imageVector = when (screen) {
                                    MainScreens.HOME -> {
                                        vectorResource(Res.drawable.ic_laser_store)
                                    }

                                    MainScreens.APPOINTMENTS -> {
                                        vectorResource(Res.drawable.ic_my_booking)
                                    }

                                    MainScreens.PROFILE -> {
                                        vectorResource(Res.drawable.ic_profile)
                                    }
                                },
                                contentDescription = screen.route,
                                colorFilter = ColorFilter.tint(MeowTheme.colors.primaryContainer),
                                alpha = if (isSelected) 1f else 0.5f,
                            )
                        },
                        selected = isSelected,
                        onClick = {
                            rootNavController.navigate(screen.route) {
                                popUpTo(rootNavController.graph.findStartDestination().route!!) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        label = {
                            Text(
                                modifier = Modifier.padding(4.dp),
                                style = TextStyles.subTitle,
                                fontSize = 12.sp,
                                text = stringResource(screen.mapForTitle()),
                                fontFamily = FontFamily(org.jetbrains.compose.resources.Font(Res.font.FjordOne_Regular)),
                                color = MeowTheme.colors.onSurfaceVariant
                            )
                        }
                    )
                }
            }
        }
    ) {
        NavHost(
            navController = rootNavController,
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

    }
}

@Composable
fun HomepageNavHost() {
    val homeNavController = rememberNavController()
    NavHost(homeNavController, MainScreens.HOME.route) {
        composable(MainScreens.HOME.route) {
            HomepageScreen()
        }
    }
}