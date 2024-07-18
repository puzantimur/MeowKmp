package meow.laser.com.theme.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import meow.composeapp.generated.resources.Aboreto_Regular
import meow.composeapp.generated.resources.FjordOne_Regular
import meow.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.Font

object TextStyles {
    val bodyL = TextStyle(
        fontSize = 16.sp,
        lineHeight = 24.sp,
        fontWeight = FontWeight.Normal,
        letterSpacing = 0.07.sp,
    )
    
    val bodyM = TextStyle(
        fontSize = 14.sp,
        lineHeight = 20.sp,
        fontWeight = FontWeight.Normal,
        letterSpacing = 0.06.sp,
    )
    
    val mainTitle = TextStyle(
        fontSize = 32.sp,
        lineHeight = 30.sp,
        fontWeight = FontWeight.Bold,
        letterSpacing = 0.06.sp,
    )
    
    val subTitle = TextStyle(
        fontSize = 18.sp,
        lineHeight = 20.sp,
        fontWeight = FontWeight.Normal,
        letterSpacing = 0.06.sp,
    )
}

@Composable
fun MeowTitleFont(): FontFamily {
    return FontFamily(Font(Res.font.Aboreto_Regular))
}

@Composable
fun MeowBodyFont(): FontFamily {
    return FontFamily(Font(Res.font.FjordOne_Regular))
}