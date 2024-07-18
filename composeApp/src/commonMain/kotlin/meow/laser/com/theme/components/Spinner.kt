package meow.laser.com.theme.components

import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.unit.dp
import meow.laser.com.theme.MeowTheme

@Composable
fun Spinner(
    modifier: Modifier = Modifier,
    size: SpinnerSize,
) {
    CircularProgressIndicator(
        modifier = modifier.size(
            when (size) {
                SpinnerSize.M -> 32.dp
                SpinnerSize.S -> 24.dp
            }
        ),
        color = MeowTheme.colors.primary,
        strokeWidth = when (size) {
            SpinnerSize.M -> 6.dp
            SpinnerSize.S -> 3.dp
        },
        strokeCap = StrokeCap.Round
    )
}

enum class SpinnerSize { M, S }