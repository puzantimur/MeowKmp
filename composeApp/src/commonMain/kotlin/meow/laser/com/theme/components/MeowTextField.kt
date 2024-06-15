package meow.laser.com.theme.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
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
) {
    OutlinedTextField(
        value = text,
        onValueChange = onTextChanged::invoke,
        label = { Text(hint) },
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = MeowTheme.colors.secondaryBackground,
            focusedContainerColor = MeowTheme.colors.secondaryBackground,
            unfocusedTextColor = MeowTheme.colors.primaryText,
            focusedTextColor = MeowTheme.colors.primaryText,
            focusedLabelColor = MeowTheme.colors.outlineTextFieldColor,
            focusedIndicatorColor = MeowTheme.colors.outlineTextFieldColor,
            cursorColor = MeowTheme.colors.outlineTextFieldColor,
        ),
        modifier = modifier.padding(all = 10.dp).fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        visualTransformation = visualTransformation
    )

}