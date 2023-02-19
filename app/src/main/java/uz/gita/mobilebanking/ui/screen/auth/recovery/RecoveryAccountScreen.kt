package uz.gita.mobilebanking.ui.screen.auth.recovery

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.androidx.AndroidScreen
import uz.gita.mobilebanking.R
import uz.gita.mobilebanking.ui.theme.MobileBankingTheme
import uz.gita.mobilebanking.util.components.AppButton
import uz.gita.mobilebanking.util.components.CustomPasswordTextField
import uz.gita.mobilebanking.util.components.CustomTextFieldWithTitle

class RecoveryAccountScreen : AndroidScreen() {

    @Composable
    override fun Content() {
        RecoveryAccountContent()
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    private fun RecoveryAccountContent() = Box {

        Column(
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 20.dp)
                .fillMaxSize(),
        ) {

            Text(text = "Sign In", modifier = Modifier.align(Alignment.CenterHorizontally))

            Spacer(modifier = Modifier.fillMaxHeight(0.06f))

            val content = remember {
                mutableStateOf("")
            }
            CustomTextFieldWithTitle(content, "Ism kiriting", stringResource(R.string.first_name))
            CustomTextFieldWithTitle(content, "", stringResource(R.string.last_name))
            CustomTextFieldWithTitle(content, "01/01/2023", stringResource(R.string.date_brith))
            CustomTextFieldWithTitle(content, "+998 93 499 60 50", stringResource(R.string.phone_number))
            CustomPasswordTextField(content = content)

            Text(text = "Gender", modifier = Modifier.padding(top = 26.dp, bottom = 5.dp))

            val isMaleGender = remember {
                mutableStateOf(true)
            }

            Row(verticalAlignment = Alignment.CenterVertically) {
               RadioButton(selected = isMaleGender.value, onClick = { isMaleGender.value = !isMaleGender.value })
                Text(text = "male")
               RadioButton(selected = !isMaleGender.value, onClick = { isMaleGender.value = !isMaleGender.value })
                Text(text = "female")
            }
            Spacer(modifier = Modifier.weight(1f))
            AppButton(text = stringResource(id = R.string.save)) {
                
            }
        }
    }

    @Preview
    @Composable
    private fun RecoveryAccountPreview() {
        MobileBankingTheme {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                RecoveryAccountContent()
            }
        }
    }
}