package dev.ayameio.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.ayameio.ui.theme.md_theme_light_primaryFixed

@Composable
fun BubbleIndicator(modifier: Modifier = Modifier) {
    Canvas(modifier = modifier
        .size(size = 160.dp)
    ) {
        drawCircle(
            color = md_theme_light_primaryFixed,
            radius = 80.dp.toPx(),
        )
    }
}