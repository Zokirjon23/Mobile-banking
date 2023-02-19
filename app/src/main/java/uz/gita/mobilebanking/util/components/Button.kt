package uz.gita.mobilebanking.util.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import uz.gita.mobilebanking.ui.screen.auth.login.LoginContract
import uz.gita.mobilebanking.ui.theme.componentColor

@Composable
fun AppButton(text : String,modifier: Modifier = Modifier,block : () -> Unit) {
    Button(
        onClick = {
            block()
        }, modifier = modifier
            .fillMaxWidth()
            .height(48.dp),
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.buttonColors(componentColor)
    ) {
        Text(text = text)
    }
}