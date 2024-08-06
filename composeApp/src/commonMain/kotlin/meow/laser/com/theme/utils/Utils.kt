package meow.laser.com.theme.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp

@Composable
fun Dp.toPx(): Int {
    return this.value.times(LocalDensity.current.density).toInt()
}

@Composable
fun Int.toDp(): Dp {
    return Dp(this.div(LocalDensity.current.density))
}