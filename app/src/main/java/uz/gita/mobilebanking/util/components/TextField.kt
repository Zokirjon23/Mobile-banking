package uz.gita.mobilebanking.util.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import uz.gita.mobilebanking.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CommonTextFieldPassword(
    password: MutableState<String>,
) {
    val passwordVisible = rememberSaveable { mutableStateOf(false) }

    TextField(
        modifier = Modifier
            .padding(top = 8.dp)
            .fillMaxWidth()
            .height(56.dp)
            .background(Color(0xFFF4F4F4), CircleShape.copy(all = CornerSize(12.dp))),
        value = password.value,
        onValueChange = { password.value = it },
        label = { Text("Password") },
        singleLine = true,
        placeholder = { Text("Password") },
        visualTransformation = if (passwordVisible.value) VisualTransformation.None else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        trailingIcon = {
            val image = if (passwordVisible.value)
                ImageVector.vectorResource(id = R.drawable.ic_outline_visibility)
            else ImageVector.vectorResource(id = R.drawable.ic_outline_visibility_off)
            val description = if (passwordVisible.value) "Hide password" else "Show password"
            IconButton(onClick = { passwordVisible.value = !passwordVisible.value }) {
                Icon(imageVector = image, description)
            }
        })
}

