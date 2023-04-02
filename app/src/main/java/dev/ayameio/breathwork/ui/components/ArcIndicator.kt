package dev.ayameio.breathwork.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import dev.ayameio.breathwork.ui.utils.drawArcs

@Composable
fun ArcIndicator(
    value: Float,
    angle: Float,
    circleSize: Dp = 60.dp,
    strokeWidth: Dp = 10.dp,
) {
    Canvas(
        modifier = Modifier
            .size(circleSize)
    ) {
        drawArcs(value, angle, strokeWidth = strokeWidth)
    }
}