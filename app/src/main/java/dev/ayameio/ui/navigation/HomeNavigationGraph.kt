package dev.ayameio.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dev.ayameio.ui.HomeScreen
import dev.ayameio.ui.OnboardScreen
import dev.ayameio.ui.ProfileScreen
import dev.ayameio.ui.SessionScreen

@Composable
fun HomeNavigationGraph(
    navController: NavHostController = rememberNavController(),
    startDestination: String = HomeDestinations.ONBOARD_ROUTE,
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
    ) {
        composable(HomeDestinations.ONBOARD_ROUTE) {
            OnboardScreen(navController = navController)
        }
        composable(HomeDestinations.PROFILE_ROUTE) {
            ProfileScreen(navController = navController)
        }
        composable(HomeDestinations.HOME_ROUTE) {
            HomeScreen(navController = navController)
        }
        composable(HomeDestinations.SESSION_ROUTE) {
            SessionScreen(navController = navController)
        }
    }
}