package com.abdullahalhakimi.shimmer

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp

@Composable
fun ShimmerTextLine(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .height(20.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(4.dp))
            .shimmer()
    )
}

@Composable
fun ShimmerAvatar(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .size(64.dp)
            .clip(CircleShape)
            .shimmer()
    )
}

@Composable
fun ShimmerCard(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .shimmer()
            .padding(16.dp)
    ) {
        ShimmerTextLine(modifier = Modifier.fillMaxWidth(0.6f))
        Spacer(modifier = Modifier.height(8.dp))
        ShimmerTextLine(modifier = Modifier.fillMaxWidth())
    }
}
