package com.abdullahalhakimi.sample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.abdullahalhakimi.sample.ui.theme.ShimmerComposeTheme
import com.abdullahalhakimi.shimmer.ShimmerAvatar
import com.abdullahalhakimi.shimmer.ShimmerCard
import com.abdullahalhakimi.shimmer.ShimmerTextLine

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ShimmerComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(Modifier.padding(innerPadding)) {
                        SampleScreen()
                    }
                }
            }
        }
    }
}

@Composable
fun SampleScreen() {
    Column(modifier = Modifier.padding(16.dp)) {
        ShimmerTextLine()
        Spacer(modifier = Modifier.height(16.dp))
        ShimmerAvatar()
        Spacer(modifier = Modifier.height(16.dp))
        ShimmerCard()
    }
}