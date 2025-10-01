package com.abdullahalhakimi.sample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.abdullahalhakimi.sample.ui.theme.ShimmerComposeTheme
import com.abdullahalhakimi.shimmer.ShimmerAvatar
import com.abdullahalhakimi.shimmer.ShimmerCard
import com.abdullahalhakimi.shimmer.ShimmerPlaceholder
import com.abdullahalhakimi.shimmer.ShimmerTextLine

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var isLoading by remember { mutableStateOf(true) }
            ShimmerComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(Modifier.padding(innerPadding)) {
                        SampleScreen()
                        Spacer(modifier = Modifier.height(50.dp))
                        UserProfileCard(isLoading = isLoading)
                    }
                }
                LaunchedEffect(Unit) {
                    kotlinx.coroutines.delay(20_000)
                    isLoading = false
                }
            }
        }
    }
}

@Composable
fun SampleScreen() {
    Column(modifier = Modifier.padding(16.dp)) {
        Spacer(modifier = Modifier.height(16.dp))
        ShimmerTextLine()
        Spacer(modifier = Modifier.height(16.dp))
        ShimmerAvatar()
        Spacer(modifier = Modifier.height(16.dp))
        ShimmerCard()
    }
}

@Composable
fun UserProfileCard(isLoading: Boolean) {
    Row(modifier = Modifier.padding(16.dp)) {
        ShimmerPlaceholder(isLoading, modifier = Modifier.size(64.dp), shape = CircleShape) {
            Image(
                painter = painterResource(R.drawable.ic_launcher_background),
                contentDescription = null,
                modifier = Modifier
                    .size(64.dp)
                    .clip(CircleShape)
            )
        }
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            ShimmerPlaceholder(isLoading, modifier = Modifier
                .height(20.dp)
                .fillMaxWidth(0.6f)) {
                Text("Abdullah Al-Hakimi", style = MaterialTheme.typography.titleMedium)
            }
            Spacer(modifier = Modifier.height(8.dp))
            ShimmerPlaceholder(isLoading, modifier = Modifier
                .height(16.dp)
                .fillMaxWidth(0.4f)) {
                Text("@abdullah", style = MaterialTheme.typography.bodySmall)
            }
        }
    }
}