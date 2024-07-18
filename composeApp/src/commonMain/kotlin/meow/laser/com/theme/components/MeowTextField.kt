package meow.laser.com.theme.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import meow.laser.com.theme.MeowTheme

@Composable
fun MeowTextField(
    text: String = "",
    hint: String,
    onTextChanged: (String) -> Unit,
    modifier: Modifier = Modifier,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardType: KeyboardType = KeyboardType.Text,
    isEnabled: Boolean = true,
) {
    OutlinedTextField(
        value = text,
        onValueChange = onTextChanged::invoke,
        label = {
            Text(text = hint, fontFamily = MeowBodyFont() )
        },
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = MeowTheme.colors.surfaceContainerLow,
            focusedContainerColor = MeowTheme.colors.surfaceContainerLow,
            focusedTextColor = MeowTheme.colors.primary,
            unfocusedTextColor = MeowTheme.colors.secondary,
            focusedLabelColor = MeowTheme.colors.primary,
            focusedIndicatorColor = MeowTheme.colors.primary,
            cursorColor = MeowTheme.colors.outlineVariant,
            disabledTextColor = MeowTheme.colors.secondary,
            disabledContainerColor = MeowTheme.colors.surfaceContainerLow,
            disabledLabelColor = MeowTheme.colors.primary,
        ),
        modifier = modifier.padding(all = 10.dp).fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        visualTransformation = visualTransformation,
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = keyboardType
        ),
        maxLines = 1,
        enabled = isEnabled,
    )

}