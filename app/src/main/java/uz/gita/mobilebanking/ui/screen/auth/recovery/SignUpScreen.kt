package uz.gita.mobilebanking.ui.screen.auth.recovery

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.hilt.getViewModel
import uz.gita.mobilebanking.R
import uz.gita.mobilebanking.data.model.SignUpData
import uz.gita.mobilebanking.presenter.SignInViewModel
import uz.gita.mobilebanking.presenter.impl.SignInViewModelImpl
import uz.gita.mobilebanking.ui.theme.MobileBankingTheme
import uz.gita.mobilebanking.util.components.AppButton
import uz.gita.mobilebanking.util.components.CustomPasswordTextField
import uz.gita.mobilebanking.util.components.CustomTextFieldWithTitle

class SignUpScreen : AndroidScreen() {

    @Composable
    override fun Content() {

        val viewModel: SignInViewModel = getViewModel<SignInViewModelImpl>()
        val uiState = viewModel.uiState.collectAsState()
        SingUpContent(uiState, viewModel::onEventDispatch)
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    private fun SingUpContent(
        state: State<SignUpContract.UIState>,
        onEvent: (SignUpContract.Intent) -> Unit
    ) = Box {

        Column(
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 20.dp)
                .fillMaxSize(),
        ) {

            Text(text = "Sign In", modifier = Modifier.align(Alignment.CenterHorizontally))

            Spacer(modifier = Modifier.fillMaxHeight(0.06f))

            val name = remember { mutableStateOf("") }
            val lastName = remember { mutableStateOf("") }
            val dateBirth = remember { mutableStateOf("") }
            val phoneNumber = remember { mutableStateOf("") }
            val password = remember { mutableStateOf("") }
            val isMaleGender = remember { mutableStateOf(true) }


            CustomTextFieldWithTitle(name, "Ism kiriting", stringResource(R.string.first_name))
            CustomTextFieldWithTitle(lastName, "", stringResource(R.string.last_name))
            CustomTextFieldWithTitle(dateBirth, "01/01/2023", stringResource(R.string.date_brith))
            CustomTextFieldWithTitle(
                phoneNumber,
                "+998 93 499 60 50",
                stringResource(R.string.phone_number)
            )
            CustomPasswordTextField(password)

            Text(text = "Gender", modifier = Modifier.padding(top = 26.dp, bottom = 5.dp))


            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = isMaleGender.value,
                    onClick = { isMaleGender.value = !isMaleGender.value })
                Text(text = "male")
                RadioButton(
                    selected = !isMaleGender.value,
                    onClick = { isMaleGender.value = !isMaleGender.value })
                Text(text = "female")
            }
            Spacer(modifier = Modifier.weight(1f))
            AppButton(text = stringResource(id = R.string.save)) {
                val signUpData = SignUpData(
                    name.value,
                    lastName.value,
                    phoneNumber.value,
                    isMaleGender.value,
                    dateBirth.value,
                    password.value
                )

                onEvent(SignUpContract.Intent.CreateUser(signUpData))
            }
        }
        if (state.value.loading)
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
    }

    @Preview
    @Composable
    private fun SingUpPreview() {
        MobileBankingTheme {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                val state = remember {
                    mutableStateOf(SignUpContract.UIState(false,null,null))
                }
                SingUpContent(state) {}
            }
        }
    }
}