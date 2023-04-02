package dev.ayameio.ui.navigation

enum class BottomNavigationTab(
    val title: String,
    val route: String
) {
    HOME(
        "Home",
        "home"
    ),
    PROFILE(
        "Profile",
        "profile"
    ),
}