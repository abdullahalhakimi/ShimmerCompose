package com.abdullahalhakimi.shimmer

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import kotlin.math.tan


/**
 * Shimmer direction options.
 */
enum class ShimmerDirection {
    LeftToRight, RightToLeft, TopToBottom, BottomToTop, Diagonal
}

/**
 * Shimmer modifier with customizable colors, speed, angle, shape, and direction.
 */
fun Modifier.shimmer(
    colors: List<Color>? = null,
    durationMillis: Int = 1000,
    angle: Float = 20f,
    direction: ShimmerDirection = ShimmerDirection.Diagonal,
    shape: Shape? = null,
    shimmerWidth: Float = 200f
): Modifier = composed {
    val isDark = isSystemInDarkTheme()
    val actualColors = colors ?: if (isDark) ShimmerDefaults.Dark else ShimmerDefaults.Light


    val transition = rememberInfiniteTransition(label = "shimmer")
    val translateAnim by transition.animateFloat(
        initialValue = 0f,
        targetValue = 1000f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "shimmerAnim",
    )

    val (start, end) = when (direction) {
        ShimmerDirection.LeftToRight -> Offset(translateAnim, 0f) to Offset(translateAnim + shimmerWidth, 0f)
        ShimmerDirection.RightToLeft -> Offset(-translateAnim, 0f) to Offset(-translateAnim - shimmerWidth, 0f)
        ShimmerDirection.TopToBottom -> Offset(0f, translateAnim) to Offset(0f, translateAnim + shimmerWidth)
        ShimmerDirection.BottomToTop -> Offset(0f, -translateAnim) to Offset(0f, -translateAnim - shimmerWidth)
        ShimmerDirection.Diagonal -> Offset(translateAnim, 0f) to Offset(
            translateAnim + shimmerWidth,
            shimmerWidth * tan(Math.toRadians(angle.toDouble())).toFloat()
        )
    }

    val brush = Brush.linearGradient(
        colors = actualColors,
        start = start,
        end = end
    )

    var base = this.background(brush)
    if (shape != null) {
        base = base.clip(shape)
    }
    base
}

/**
 * Preset shimmer color themes.
 */
object ShimmerDefaults {
    val Light = listOf(
        Color.LightGray.copy(alpha = 0.6f),
        Color.LightGray.copy(alpha = 0.2f),
        Color.LightGray.copy(alpha = 0.6f)
    )

    val Dark = listOf(
        Color.DarkGray.copy(alpha = 0.6f),
        Color.Gray.copy(alpha = 0.2f),
        Color.DarkGray.copy(alpha = 0.6f)
    )
}
