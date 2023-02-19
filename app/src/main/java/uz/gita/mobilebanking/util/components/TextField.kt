package uz.gita.mobilebanking.util.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import uz.gita.mobilebanking.R


@Composable
fun CustomTextField(
    content : MutableState<String>,
    placeHolder : String,
    modifier: Modifier = Modifier,
){
    OutlinedTextField(
        modifier = modifier
            .padding(top = 8.dp)
            .fillMaxWidth()
            .height(56.dp)
            .background(Color(0xFFF4F4F4), CircleShape.copy(all = CornerSize(12.dp))),
        value = content.value,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Transparent,
            unfocusedBorderColor = Color.Transparent
        ),
        onValueChange = { content.value = it },
        singleLine = true,
        placeholder = { Text(placeHolder) },
        )
}

@Composable
fun CustomTextFieldWithTitle(
    content : MutableState<String>,
    placeHolder : String,
    title :String,
    modifier: Modifier = Modifier

){
    Column(modifier= modifier.padding(top = 16.dp)) {
        Text(text = title, color = Color.Black)

        OutlinedTextField(
            modifier = Modifier
                .padding(top = 8.dp)
                .fillMaxWidth()
                .height(56.dp)
                .background(Color(0xFFF4F4F4), CircleShape.copy(all = CornerSize(12.dp))),
            value = content.value,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent
            ),
            onValueChange = { content.value = it },
            singleLine = true,
            placeholder = { Text(placeHolder) },
        )
    }
}

@Composable
fun CustomPasswordTextField(
    content : MutableState<String>,
    modifier: Modifier = Modifier
) {
    val passwordVisible = remember {
        mutableStateOf(false)
    }

    Column(modifier.padding(top = 16.dp)) {
        Text(text = stringResource(id = R.string.password), color = Color.Black)

        OutlinedTextField(
            modifier = Modifier
                .padding(top = 8.dp)
                .fillMaxWidth()
                .height(56.dp)
                .background(Color(0xFFF4F4F4), CircleShape.copy(all = CornerSize(12.dp))),
            value = content.value,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent
            ),
            onValueChange = { content.value = it },
            singleLine = true,
            placeholder = { Text("Password") },
            visualTransformation = if (passwordVisible.value) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            trailingIcon = {
                val image = if (passwordVisible.value)
                    ImageVector.vectorResource(id = R.drawable.ic_outline_visibility)
                else ImageVector.vectorResource(id = R.drawable.ic_outline_visibility_off)
                val description =
                    if (passwordVisible.value) "Hide password" else "Show password"
                IconButton(onClick = { passwordVisible.value = !passwordVisible.value }) {
                    Icon(imageVector = image, description)
                }
            })
    }
}