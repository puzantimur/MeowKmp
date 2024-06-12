import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import meow.laser.com.theme.MeowColors
import org.jetbrains.compose.ui.tooling.preview.Preview

val lightPalette = MeowColors(
    primaryText = Color(0xFF000000),
    primaryBackground = Color(0xFFCCDED1),
    primaryButtonColor = Color(0xFF6FA28E),
    secondaryBackground = Color(0xF2F4836),
    secondaryText = Color(0xFF5C8A70),
    secondaryButtonColor = Color(0xFF5C8A70),
    outlineTextFieldColor = Color(0xFF2B4033)
)

val darkPalette = MeowColors(
    primaryText = Color(0xFF43674D),
    primaryBackground = Color(0xFFFFFFFF),
    secondaryText = Color(0xFFEAF2EC),
    secondaryBackground = Color(0xFF6FA17D),
    secondaryButtonColor = Color(0xFF5C8A70),
    outlineTextFieldColor = Color(0xFF2B4033),
    primaryButtonColor = Color(0xFF54C785),
)

@Preview
@Composable
fun PreviewColor() {
    Column {
        Box(modifier = Modifier.background(lightPalette.primaryBackground).height(20.dp).width(20.dp))
        Spacer(Modifier.padding(10.dp))
        Box(modifier = Modifier.background(lightPalette.primaryText).height(20.dp).width(20.dp))
        Spacer(Modifier.padding(10.dp))
        Box(modifier = Modifier.background(lightPalette.secondaryBackground).height(20.dp).width(20.dp))
        Spacer(Modifier.padding(10.dp))
        Box(modifier = Modifier.background(lightPalette.secondaryText).height(20.dp).width(20.dp))
        Spacer(Modifier.padding(10.dp))
        Box(modifier = Modifier.background(darkPalette.primaryBackground).height(20.dp).width(20.dp))
        Spacer(Modifier.padding(10.dp))
        Box(modifier = Modifier.background(darkPalette.primaryBackground).height(20.dp).width(20.dp))
        Spacer(Modifier.padding(10.dp))
        Box(modifier = Modifier.background(darkPalette.secondaryBackground).height(20.dp).width(20.dp))
        Spacer(Modifier.padding(10.dp))
        Box(modifier = Modifier.background(darkPalette.secondaryText).height(20.dp).width(20.dp))
        Spacer(Modifier.padding(10.dp))
    }

}