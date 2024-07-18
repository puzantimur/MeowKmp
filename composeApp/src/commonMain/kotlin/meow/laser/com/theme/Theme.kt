package meow.laser.com.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier

internal val LocalThemeIsDark = compositionLocalOf { mutableStateOf(true) }

@Composable
fun MeowTheme(
    content: @Composable () -> Unit,
) {
    val systemIsDark = isSystemInDarkTheme()
    val isDarkState = remember { mutableStateOf(systemIsDark) }
    val palette = if (systemIsDark) darkPalette else lightPalette
    CompositionLocalProvider(
        LocalThemeIsDark provides isDarkState,
        LocalMeowColors provides palette,
        content = {
            Box(modifier = Modifier.fillMaxSize().background(MeowTheme.colors.surfaceBright)) {
                content()
            }
        }
    )
}

@Composable
internal expect fun SystemAppearance(isDark: Boolean)
