package meow.laser.com.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

data class MeowColors(
    val primaryText: Color,
    val primaryBackground: Color,
    val primaryButtonColor: Color,
    val secondaryText: Color,
    val secondaryBackground: Color,
    val secondaryButtonColor: Color,
    val outlineTextFieldColor: Color,
)

object MeowTheme{
    val colors: MeowColors
    @Composable
    get() = LocalMeowColors.current
}

val LocalMeowColors = staticCompositionLocalOf<MeowColors> { error("No default impl for colors") }