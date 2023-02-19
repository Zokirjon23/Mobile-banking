package uz.gita.mobilebanking.ui.screen.auth.recovery

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import cafe.adriel.voyager.androidx.AndroidScreen

class RecoveryAccountScreen : AndroidScreen() {

    @Composable
    override fun Content() {
        RecoveryAccountContent()
    }

    @Composable
    private fun RecoveryAccountContent() = Box {

    }

    @Preview
    @Composable
    private fun RecoveryAccountPreview() {

    }
}