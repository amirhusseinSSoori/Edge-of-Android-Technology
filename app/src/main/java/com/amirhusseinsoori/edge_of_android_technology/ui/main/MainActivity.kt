package com.amirhusseinsoori.edge_of_android_technology.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.amirhusseinsoori.edge_of_android_technology.ui.intro.IntroScreen
import com.amirhusseinsoori.edge_of_android_technology.ui.theme.EdgeofAndroidTechnologyTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EdgeofAndroidTechnologyTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
               IntroScreen()
                }
            }
        }
    }
}

