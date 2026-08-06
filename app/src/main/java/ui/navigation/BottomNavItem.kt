package au.edu.jcu.cyberpulseedu.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.Quiz
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShowChart
import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavItem(
    val destination: AppDestination,
    val icon: ImageVector
)

val bottomNavigationItems = listOf(
    BottomNavItem(
        destination = AppDestination.Home,
        icon = Icons.Default.Home
    ),
    BottomNavItem(
        destination = AppDestination.Learn,
        icon = Icons.Default.MenuBook
    ),
    BottomNavItem(
        destination = AppDestination.Quiz,
        icon = Icons.Default.Quiz
    ),
    BottomNavItem(
        destination = AppDestination.Statistics,
        icon = Icons.Default.ShowChart
    )
)