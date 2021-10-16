package com.amirhusseinsoori.edge_of_android_technology.ui.navigation

import androidx.compose.animation.*
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NamedNavArgument
import com.amirhusseinsoori.edge_of_android_technology.ui.intro.IntroScreen
import com.amirhusseinsoori.edge_of_android_technology.ui.movies.MovieScreen
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable


@ExperimentalComposeUiApi
@ExperimentalFoundationApi
@ExperimentalAnimationApi
@Composable
fun InitialNavGraph(navController: NavHostController) {
    AnimatedNavHost(navController = navController, startDestination = ScreenRoute.Intro.route) {
        addIntro(navController)
        addMovie(navController)
    }
}

@ExperimentalAnimationApi
fun NavGraphBuilder.addIntro(navController: NavController) {
    composable(ScreenRoute.Intro.route,
        enterTransition = { initial, _ ->
            when (initial.destination.route) {
                ScreenRoute.MovieRoute.route ->
                    slideInHorizontally(
                        initialOffsetX = { 300 },
                        animationSpec = tween(300)
                    ) + fadeIn(animationSpec = tween(300))
                else -> null
            }
        },
        exitTransition = { _, target ->
            when (target.destination.route) {
                ScreenRoute.MovieRoute.route ->
                    slideOutHorizontally(
                        targetOffsetX = { 300 },
                        animationSpec = tween(300)
                    ) + fadeOut(animationSpec = tween(300))
                else -> null
            }
        },
        popEnterTransition = { initial, _ ->
            when (initial.destination.route) {
                ScreenRoute.MovieRoute.route ->
                    slideInHorizontally(
                        initialOffsetX = { 300 },
                        animationSpec = tween(300)
                    ) + fadeIn(animationSpec = tween(300))
                else -> null
            }
        }) {
        IntroScreen(navController)
    }


}

@ExperimentalFoundationApi
@ExperimentalComposeUiApi
@ExperimentalAnimationApi
fun NavGraphBuilder.addMovie(
    navController: NavController
) {
    composable(
        route = ScreenRoute.MovieRoute.route,
        exitTransition = { _, _ ->
            slideOutHorizontally(
                targetOffsetX = { 300 },
                animationSpec = tween(
                    durationMillis = 300,
                    easing = FastOutSlowInEasing
                )
            ) + fadeOut(animationSpec = tween(300))
        },
        popEnterTransition = { initial, _ ->
            slideInHorizontally(
                initialOffsetX = { 300 },
                animationSpec = tween(
                    durationMillis = 300,
                    easing = FastOutSlowInEasing
                )
            ) + fadeIn(animationSpec = tween(300))
        },
    ) {
        MovieScreen(hiltViewModel())
    }
}

sealed class ScreenRoute(val route: String, val arguments: List<NamedNavArgument>) {
    object Intro : ScreenRoute("ScreenIntro", arguments = emptyList())
    object MovieRoute : ScreenRoute(
        route = "ScreenMovie",
        arguments = emptyList()
    )


}




