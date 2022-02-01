package com.example.jetpackcomposetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.jetpackcomposetutorial.ui.theme.JetpackComposeTutorialTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTutorialTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting(
                        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTwzF6ZipCh3_AcIho22fXQyvr2QSm2zZgq677xCnpS-IZor0dWyrrHQma6FUyGt2qXUFI&usqp=CAU",
                        "Ahmed",
                        "Android Application Developer"
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(imageUrl: String, name: String, occupation: String) {
    Row(modifier = Modifier.padding(all = 8.dp)) {
        Image(
            painter = rememberImagePainter(
                data = imageUrl,
                builder = {
                    crossfade(true)
                }
            ),
            contentDescription = "Profile Image",
            modifier = Modifier.size(48.dp).align(CenterVertically).clip(RoundedCornerShape(4.dp)).padding(8.dp,6.dp,0.dp,0.dp)
        )
        Spacer(modifier = Modifier.width(10.dp))
        Column {
            Text(text = "Hello $name!")
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "You're $occupation.")
        }
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeTutorialTheme {
        Greeting("", " Ahmed ", " Android Application Developer ")
    }
}