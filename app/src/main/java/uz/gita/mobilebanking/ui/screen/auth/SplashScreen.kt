package uz.gita.mobilebanking.ui.screen.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.hilt.getViewModel
import uz.gita.mobilebanking.R
import uz.gita.mobilebanking.presenter.SplashViewModel
import uz.gita.mobilebanking.presenter.impl.SplashViewModelImpl
import uz.gita.mobilebanking.ui.theme.MobileBankingTheme
import uz.gita.mobilebanking.ui.theme.Purple80
import uz.gita.mobilebanking.util.components.IconResource

class SplashScreen : AndroidScreen() {

    @Composable
    override fun Content() {
        val viewModel: SplashViewModel = getViewModel<SplashViewModelImpl>()
        SplashScreenContent()
    }

    @Composable
    fun SplashScreenContent() {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .background(Purple80)
                .padding(end = 3.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            IconResource(res = R.drawable.ic_splash, tint = Color(0xFF00AAFF))
            Text(
                text = stringResource(id = R.string.gita_bank),
                fontSize = 25.sp,
                fontStyle = FontStyle.Italic,
                color = Color.White
            )
        }
    }

    @Preview
    @Composable
    fun SplashScreenPreview() {
        MobileBankingTheme {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                SplashScreenContent()
            }
        }
    }
}