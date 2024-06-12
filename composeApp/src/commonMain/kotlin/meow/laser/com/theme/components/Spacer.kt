package meow.laser.com.theme.components

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp

@Composable
fun ColumnScope.MeowSpacer(size: Dp) {
    Spacer(modifier = Modifier.height(size))
}

@Composable
fun RowScope.MeowSpacer(size: Dp) {
    Spacer(modifier = Modifier.width(size))
}