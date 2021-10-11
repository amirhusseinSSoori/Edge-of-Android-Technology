package com.amirhusseinsoori.edge_of_android_technology.ui.intro

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.amirhusseinsoori.edge_of_android_technology.R
import com.amirhusseinsoori.edge_of_android_technology.ui.navigation.ScreenRoute
import com.amirhusseinsoori.edge_of_android_technology.ui.theme.black
import com.amirhusseinsoori.edge_of_android_technology.util.Loader
import kotlinx.coroutines.delay

@Composable
fun IntroScreen(navController: NavController){
    val scale = remember { Animatable(0f) }
    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 0.3f,
            animationSpec = tween(
                durationMillis = 500,
                easing = {
                    OvershootInterpolator(2f).getInterpolation(it)
                }
            )
        )
        delay(3000L)
        navController.navigate(ScreenRoute.MovieRoute.route) {
            popUpTo(ScreenRoute.Intro.route) { inclusive = true }
            launchSingleTop = true
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(black), horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Loader(R.raw.movie_intro)
    }
}