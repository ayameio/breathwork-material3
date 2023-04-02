package dev.ayameio.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun HomeNavigationGraph(
    navController: NavHostController = rememberNavController(),
    startDestination: String = HomeDestinations.HOME_ROUTE
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
    ) {
        composable(HomeDestinations.HOME_ROUTE) {
            HomeScreen(navController = navController)
        }
        composable(HomeDestinations.PROFILE_ROUTE) {
            ProfileScreen(navController = navController)
        }
    }
}