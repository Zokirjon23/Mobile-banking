package uz.gita.mobilebanking.ui.screen.auth.login

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.hilt.getViewModel
import uz.gita.mobilebanking.R
import uz.gita.mobilebanking.presenter.LoginViewModel
import uz.gita.mobilebanking.presenter.impl.LoginViewModelImpl
import uz.gita.mobilebanking.ui.theme.MobileBankingTheme
import uz.gita.mobilebanking.ui.theme.componentColor

class LoginScreen : AndroidScreen() {
    @Composable
    override fun Content() {
        val viewModel: LoginViewModel = getViewModel<LoginViewModelImpl>()
        val state = viewModel.uiStateFlow.collectAsState()
        LoginScreenContent(state, viewModel::onEventDispatch)
    }

    @Composable
    private fun LoginScreenContent(
        uiState: State<LoginContract.UiState>,
        event: (LoginContract.Intent) -> Unit
    ) = Box {
        val passwordVisible = rememberSaveable { mutableStateOf(false) }
        val password = rememberSaveable { mutableStateOf("") }
        val phone = rememberSaveable { mutableStateOf("") }

//        val context = LocalContext.current
//        LaunchedEffect(key1 = uiState.value.message, key2 = uiState.value.error) {
//            Toast.makeText(context, uiState.value.message, Toast.LENGTH_SHORT).show()
//            Toast.makeText(context, uiState.value.error, Toast.LENGTH_SHORT).show()
//        }

        Column(
            modifier = Modifier
                .padding(horizontal = 27.dp, vertical = 20.dp)
                .fillMaxSize()
        ) {
            Text(
                text = "Sign in",
                fontSize = 20.sp,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.fillMaxHeight(0.15f))
            Text(text = "Phone number")



            BasicTextField(
                value = phone.value, onValueChange = { phone.value = it },
                modifier = Modifier
                    .padding(top = 8.dp)
                    .fillMaxWidth()
                    .height(56.dp)
                    .background(Color(0xFFF4F4F4), CircleShape.copy(all = CornerSize(12.dp))),
//                decorationBox = {
//                    Row(
//                        modifier = Modifier
//                            .padding(start = 15.dp)
//                            .fillMaxSize(), verticalAlignment = Alignment.CenterVertically
//                    ) {
//                        Text(text = "+998 ", color = Color.Black)
//                        Text(
//                            text = "000-00-00", color = Color(0x4D000000)
//                        )
//                    }
//                }
            )

            OutlinedTextField(
                modifier = Modifier
                    .padding(top = 8.dp)
                    .fillMaxWidth()
                    .height(56.dp)
                    .background(Color(0xFFF4F4F4), CircleShape.copy(all = CornerSize(12.dp))),
                value = password.value,
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Transparent,
                    unfocusedBorderColor = Color.Transparent
                ),
                onValueChange = { password.value = it },
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
            Text(
                "Forgot password!",
                color = componentColor,
                modifier = Modifier
                    .padding(top = 48.dp)
                    .clickable { event(LoginContract.Intent.ForgotPassword) }
            )
            Spacer(modifier = Modifier.weight(1f))
            Button(
                onClick = {
                   event(LoginContract.Intent.Login(phone.value,password.value))
                }, modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(componentColor)
            ) {
                Text(text = "Enter")
            }
        }

        if (uiState.value.isLoading == true) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0x33FFFFFF))
            ) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
        }
    }

    @Preview
    @Composable
    fun LoginScreenPreView() {
        MobileBankingTheme {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                val state = remember {
                    mutableStateOf(LoginContract.UiState(false))
                }
                LoginScreenContent(state) {}
            }
        }
    }
}