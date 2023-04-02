package dev.ayameio.breathwork.ui.navigation

import android.graphics.drawable.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon

enum class BottomNavigationTab(
    val title: String,
    val route: String,
) {
    HOME(
        "Home",
        "home",
    ),
    PROFILE(
        "Profile",
        "profile"
    ),
    SESSION(
        "Session",
        "session"
    )
}