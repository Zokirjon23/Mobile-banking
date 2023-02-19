package uz.gita.mobilebanking.util.components

import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import uz.gita.mobilebanking.R
import uz.gita.mobilebanking.ui.theme.Purple80

@Composable
fun IconResource(res: Int, tint: Color = Purple80) {
    Icon(
        imageVector = ImageVector.vectorResource(id = res),
        contentDescription = null,
        tint = tint
    )
}