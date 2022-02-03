package com.example.splashscreensample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.splashscreensample.ui.theme.SplashScreenSampleTheme

class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen().apply {
            setKeepOnScreenCondition() {
                viewModel.isLoading.value
            }
        }

        setContent {
            SplashScreenSampleTheme {
                HelloWorld()
            }
        }
    }
}

@Composable
fun HelloWorld() {
    Box(
        modifier = Modifier.fillMaxSize().background(Color(0xFFFFFFFF)),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Hello World!")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SplashScreenSampleTheme {
        HelloWorld()
    }
}