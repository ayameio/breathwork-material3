package dev.ayameio.ui.navigation

import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController

object HomeDestinations {
    const val ONBOARD_ROUTE = "onboard"
    const val HOME_ROUTE = "home"
    const val PROFILE_ROUTE = "profile"
    const val SESSION_ROUTE = "session"
}

class HomeNavigationActions(navController: NavHostController) {
    val navigateToHome: () -> Unit = {
        navController.navigate(HomeDestinations.HOME_ROUTE) {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }
    val navigateToProfile: () -> Unit = {
        navController.navigate(HomeDestinations.PROFILE_ROUTE) {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }
    val navigateToSession: () -> Unit = {
        navController.navigate(HomeDestinations.SESSION_ROUTE) {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }
}