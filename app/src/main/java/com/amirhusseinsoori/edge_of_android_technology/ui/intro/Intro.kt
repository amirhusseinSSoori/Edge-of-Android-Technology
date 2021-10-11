package com.amirhusseinsoori.edge_of_android_technology.ui.intro

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.amirhusseinsoori.edge_of_android_technology.R
import com.amirhusseinsoori.edge_of_android_technology.ui.theme.black
import com.amirhusseinsoori.edge_of_android_technology.ui.theme.white
import com.amirhusseinsoori.edge_of_android_technology.util.Loader
import com.amirhusseinsoori.edge_of_android_technology.util.utilFont
import kotlinx.coroutines.delay

@Composable
fun IntroScreen(){
//    val scale = remember { Animatable(0f) }
//    LaunchedEffect(key1 = true) {
//        scale.animateTo(
//            targetValue = 0.3f,
//            animationSpec = tween(
//                durationMillis = 500,
//                easing = {
//                    OvershootInterpolator(2f).getInterpolation(it)
//                }
//            )
//        )
//    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(black), horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Loader(R.raw.movie_intro)
    }
}