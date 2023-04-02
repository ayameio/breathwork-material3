package dev.ayameio.ui.utils

import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.Dp
import dev.ayameio.ui.theme.md_theme_light_secondaryContainer

fun DrawScope.drawArcs(
    progress: Float,
    maxValue: Float,
    strokeWidth: Dp,
) {
    val startAngle = 270 - maxValue / 2
    val sweepAngle = maxValue * progress

    fun drawStroke() {
        drawArc(
            color = md_theme_light_secondaryContainer,
            startAngle = startAngle,
            sweepAngle = sweepAngle,
            useCenter = false,
            style = Stroke(width = strokeWidth.toPx(), cap = StrokeCap.Round)
        )
    }

    drawStroke()
}