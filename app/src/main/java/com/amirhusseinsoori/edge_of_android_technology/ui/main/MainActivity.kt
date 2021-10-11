package com.amirhusseinsoori.edge_of_android_technology.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.amirhusseinsoori.edge_of_android_technology.ui.intro.IntroScreen
import com.amirhusseinsoori.edge_of_android_technology.ui.navigation.InitialNavGraph
import com.amirhusseinsoori.edge_of_android_technology.ui.theme.EdgeofAndroidTechnologyTheme
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalFoundationApi
@ExperimentalComposeUiApi
@ExperimentalAnimationApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EdgeofAndroidTechnologyTheme {
                val navController: NavHostController = rememberAnimatedNavController()
                Surface(color = MaterialTheme.colors.background) {
                    InitialNavGraph(navController)
                }
            }
        }
    }
}

