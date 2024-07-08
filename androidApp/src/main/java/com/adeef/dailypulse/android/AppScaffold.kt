package com.adeef.dailypulse.android

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.adeef.dailypulse.android.screens.AboutScreen
import com.adeef.dailypulse.android.screens.ArticleScreen
import com.adeef.dailypulse.android.screens.Screen
import com.adeef.dailypulse.articles.ArticlesViewModel

@Composable
fun AppScaffold(articlesViewModel: ArticlesViewModel) {
    val navController = rememberNavController()

    Scaffold {
        AppNavHost(
            navController = navController,
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            articlesViewModel
        )
    }
}

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    articlesViewModel: ArticlesViewModel
) {
    NavHost(
        navController = navController,
        startDestination = Screen.ARTICLES.route,
        modifier = modifier,
    ) {
        composable(Screen.ARTICLES.route) {
            ArticleScreen(
                onAboutButtonClick = { navController.navigate(Screen.ABOUT_DEVICE.route) },
                articlesViewModel,
            )
        }

        composable(Screen.ABOUT_DEVICE.route) {
            AboutScreen(
                onUpButtonClick = { navController.popBackStack() }
            )
        }
    }
}