package meow.laser.com.theme.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import meow.laser.com.theme.MeowTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

sealed class ButtonType {
    data object Primary : ButtonType()
    data object Secondary : ButtonType()
}

enum class ButtonSize { L, M, S }

@Composable
fun MeowButton(
    modifier: Modifier = Modifier,
    type: ButtonType = ButtonType.Primary,
    buttonSize: ButtonSize = ButtonSize.M,
    text: String,
    onButtonClick: () -> Unit,
    enabled: Boolean = true,
    showProgress: Boolean = false,
) {
    val buttonColors = buttonColors(type, enabled)
    val buttonHeight: Dp = remember(buttonSize) {
        when (buttonSize) {
            ButtonSize.L -> 32.dp
            ButtonSize.M -> 24.dp
            ButtonSize.S -> 14.dp
        }
    }
    OutlinedButton(
        modifier = modifier.padding(all = 10.dp).fillMaxWidth(),
        enabled = enabled,
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 12.dp),
        colors = buttonColors,
        onClick = { onButtonClick() },
        content = {
            if (showProgress) {
                Box(
                    modifier = Modifier.height(height = buttonHeight),
                    contentAlignment = Alignment.Center,
                    content = { Spinner(size = SpinnerSize.M) }
                )
            } else {
                val renderText: (@Composable () -> Unit) = {
                    Text(
                        modifier = Modifier,
                        text = text,
                        fontWeight = FontWeight.Black,
                        fontSize = when (buttonSize) {
                            ButtonSize.L -> 16.sp
                            ButtonSize.M -> 14.sp
                            ButtonSize.S -> 16.sp
                        },
                        lineHeight = 16.sp,
                        letterSpacing = 0.4.sp,
                        fontFamily = MeowBodyFont(),
                    )
                }
                Box(
                    modifier = Modifier.height(height = buttonHeight),
                    contentAlignment = Alignment.Center,
                    content = { renderText() }
                )
            }
        },
        shape = RoundedCornerShape(16.dp)
    )
}

@Composable
private fun buttonColors(type: ButtonType, buttonEnabled: Boolean): ButtonColors {
    val backgroundColor = if (buttonEnabled) {
        when (type) {
            is ButtonType.Primary -> MeowTheme.colors.primaryContainer
            is ButtonType.Secondary -> MeowTheme.colors.tertiaryContainer
        }
    } else {
        when (type) {
            is ButtonType.Primary -> MeowTheme.colors.primaryContainer.copy(alpha = 0.5f)
            is ButtonType.Secondary -> MeowTheme.colors.tertiaryContainer.copy(alpha = 0.5f)
        }
    }
    return ButtonDefaults.outlinedButtonColors().copy(
        containerColor = backgroundColor,
        contentColor = MeowTheme.colors.onPrimary
    )
}

@Composable
@Preview
fun ButtonPreview() {
    MeowButton(onButtonClick = {}, text = "Click", buttonSize = ButtonSize.S)
}