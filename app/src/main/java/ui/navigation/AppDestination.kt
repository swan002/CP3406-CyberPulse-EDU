package au.edu.jcu.cyberpulseedu.ui.navigation

sealed class AppDestination(
    val route: String,
    val title: String
) {
    data object Home : AppDestination(
        route = "home",
        title = "Home"
    )

    data object Learn : AppDestination(
        route = "learn",
        title = "Learn"
    )

    data object Quiz : AppDestination(
        route = "quiz",
        title = "Quiz"
    )

    data object Statistics : AppDestination(
        route = "statistics",
        title = "Statistics"
    )

    data object Settings : AppDestination(
        route = "settings",
        title = "Settings"
    )
}