package dev.ayameio.breathwork

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import dev.ayameio.breathwork.ui.navigation.BottomNavigationTab
import dev.ayameio.breathwork.ui.navigation.HomeDestinations
import dev.ayameio.breathwork.ui.navigation.HomeNavigationActions
import dev.ayameio.breathwork.ui.navigation.HomeNavigationGraph
import dev.ayameio.breathwork.ui.theme.PlaygroundTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Preview(showSystemUi = true)
@Composable
fun PlaygroundApp(modifier: Modifier = Modifier) {
    PlaygroundTheme {
        var selectedItem by remember { mutableStateOf(1) }
        val navController = rememberNavController()
        val navigationActions = remember(navController) { HomeNavigationActions(navController) }
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute =
            navBackStackEntry?.destination?.route ?: HomeDestinations.ONBOARD_ROUTE

        val showBottomBar = navController.currentBackStackEntryAsState().value?.destination?.route in BottomNavigationTab.values().map { it.route }

        /*
            if showBottomBar is true, that means we passed the 'log in' stage ->> show bottomBar and topBar

            we will need to hide the bottom navigation while having a breathwork session too
            create a function to evaluate whether we should hide the navbar or no..
        */
        Scaffold(
            topBar = {
                if (showBottomBar) {
                    TopAppBar(title = { Text(text = currentRoute.replaceFirstChar{ it.uppercase() }) })
                }
            },
            bottomBar = {
                if (showBottomBar) {
                    NavigationBar {
                        NavigationBarItem(
                            selected = selectedItem == 0,
                            onClick = {
                                navigationActions.navigateToProfile()
                                selectedItem = 0
                            },
                            icon = {
                                Icon(
                                    imageVector = Icons.Default.AccountCircle,
                                    contentDescription = "Profile"
                                )
                            },
                            label = { Text(text = "Profile") }
                        )
                        NavigationBarItem(
                            selected = selectedItem == 1,
                            onClick = {
                                navigationActions.navigateToHome()
                                selectedItem = 1
                            },
                            icon = {
                                Icon(
                                    imageVector = Icons.Default.Home,
                                    contentDescription = "Home",
                                )
                            },
                            label = { Text(text = "Home") }
                        )
                        NavigationBarItem(
                            selected = selectedItem == 2,
                            onClick = {
                                navigationActions.navigateToSession()
                                selectedItem = 2
                            },
                            icon = {
                                Icon(
                                    imageVector = Icons.Default.Star,
                                    contentDescription = "Session"
                                )
                            },
                            label = { Text(text = "Session") }
                        )
                    }
                }
            }
        ) { innerPadding ->
            Box(modifier = Modifier.padding(innerPadding)) {
                HomeNavigationGraph(
                    navController = navController
                )
            }
        }
    }
}