package meow.laser.com.navigation.main.utils

import meow.composeapp.generated.resources.Res
import meow.composeapp.generated.resources.bottom_nav_tab_appointment
import meow.composeapp.generated.resources.bottom_nav_tab_homepage
import meow.composeapp.generated.resources.bottom_nav_tab_profile
import meow.laser.com.navigation.main.MainScreens
import org.jetbrains.compose.resources.StringResource


internal fun MainScreens.mapForTitle(): StringResource {
    return when(this) {
        MainScreens.HOME -> Res.string.bottom_nav_tab_homepage
        MainScreens.APPOINTMENTS -> Res.string.bottom_nav_tab_appointment
        MainScreens.PROFILE -> Res.string.bottom_nav_tab_profile
    }
}