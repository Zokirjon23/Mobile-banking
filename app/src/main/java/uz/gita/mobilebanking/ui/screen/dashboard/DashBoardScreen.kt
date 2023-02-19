package uz.gita.mobilebanking.ui.screen.dashboard

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import cafe.adriel.voyager.androidx.AndroidScreen

class DashBoardScreen : AndroidScreen() {

    @Composable
    override fun Content() {
        DashBoardScreenContent()
    }

    @Composable
    private fun DashBoardScreenContent() = Box {

    }

    @Preview
    @Composable
    private fun DashBoardScreenPreview() {

    }
}