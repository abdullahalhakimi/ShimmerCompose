package com.abdullahalhakimi.shimmer

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp

/**
 * Reusable shimmer placeholder composable.
 */
@Composable
fun ShimmerPlaceholder(
    isLoading: Boolean,
    modifier: Modifier = Modifier,
    shape: Shape = RoundedCornerShape(4.dp),
    content: @Composable () -> Unit
) {
    if (isLoading) {
        Box(
            modifier = modifier.shimmer(shape = shape)
        )
    } else {
        content()
    }
}

/**
 * Ready-to-use shimmer components.
 */
@Composable
fun ShimmerTextLine(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .height(20.dp)
            .fillMaxWidth()
            .shimmer(shape = RoundedCornerShape(4.dp))
    )
}

@Composable
fun ShimmerAvatar(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .size(64.dp)
            .shimmer(shape = CircleShape)
    )
}

@Composable
fun ShimmerCard(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .shimmer(shape = RoundedCornerShape(8.dp))
            .padding(16.dp)
    ) {
        ShimmerTextLine(modifier = Modifier.fillMaxWidth(0.6f))
        Spacer(modifier = Modifier.height(8.dp))
        ShimmerTextLine(modifier = Modifier.fillMaxWidth())
    }
}
