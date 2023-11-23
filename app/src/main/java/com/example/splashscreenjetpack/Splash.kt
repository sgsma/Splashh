package com.example.splashscreenjetpack

import android.view.animation.OvershootInterpolator
import android.window.SplashScreen
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {
    Box(modifier = Modifier.fillMaxSize()) {
        val scale = remember {
            androidx.compose.animation.core.Animatable(initialValue = 0.0f)
        }
        val rotation = remember {
            androidx.compose.animation.core.Animatable(initialValue = 0f)
        }
        val alpha = remember {
            androidx.compose.animation.core.Animatable(initialValue = 0f)
        }
        LaunchedEffect(key1 = true) {
            scale.animateTo(
                targetValue = 0.5f,
                animationSpec = tween(durationMillis = 850, easing = {
                    OvershootInterpolator(4f).getInterpolation(it)
                })
            )
            rotation.animateTo(
                targetValue = 360f,
                animationSpec = tween(durationMillis = 5000, easing = LinearEasing)
            )
            alpha.animateTo(
                targetValue = 1f,
                animationSpec = tween(durationMillis = 3000)
            )
            delay(1000)
            navController.popBackStack()
            navController.navigate(Screen.Main)
        }
        Image(
            painter = painterResource(id = R.drawable.sharp_movie_filter_black_20),
            contentDescription = "Logo",
            alignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(45.dp)
                .scale(scale.value)
                .rotate(rotation.value)
        )
        Text(
            text = "My App",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(90.dp)
                .alpha(alpha.value)
        )
    }
}



@Composable
@Preview
fun vista (){
    Column {

    }

}