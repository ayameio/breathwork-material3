package dev.ayameio.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SettingArc(
    value: Float = 1f,
    maxValue: Float = 2f,
    minValue: Float = 0f
) {
    var normalized = (value - minValue) / (maxValue - minValue)
    Box(
        modifier = Modifier.size(70.dp),
        contentAlignment = Alignment.BottomCenter,
    ) {
        ArcIndicator(
            normalized,
            240f,
        )
        Text(
            modifier = Modifier.align(Alignment.Center),
            text = "${value.toInt()}",
            style = TextStyle(fontWeight = FontWeight.Black, fontSize = 18.sp)
        )
    }
}