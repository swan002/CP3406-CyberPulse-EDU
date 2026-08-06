package au.edu.jcu.cyberpulseedu

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import au.edu.jcu.cyberpulseedu.ui.navigation.AppDestination
import au.edu.jcu.cyberpulseedu.ui.navigation.AppNavGraph
import au.edu.jcu.cyberpulseedu.ui.navigation.bottomNavigationItems
import au.edu.jcu.cyberpulseedu.ui.theme.CyberPulseEDUTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            CyberPulseEDUTheme {
                CyberPulseEduApp()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CyberPulseEduApp() {
    val navController = rememberNavController()

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    val currentRoute = currentDestination?.route

    val currentTitle = when (currentRoute) {
        AppDestination.Home.route -> AppDestination.Home.title
        AppDestination.Learn.route -> AppDestination.Learn.title
        AppDestination.Quiz.route -> AppDestination.Quiz.title
        AppDestination.Statistics.route -> AppDestination.Statistics.title
        AppDestination.Settings.route -> AppDestination.Settings.title
        else -> "CyberPulse EDU"
    }

    val showBottomBar = bottomNavigationItems.any { item ->
        item.destination.route == currentRoute
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),

        topBar = {
            TopAppBar(
                title = {
                    Text(text = currentTitle)
                },

                actions = {
                    if (currentRoute != AppDestination.Settings.route) {
                        IconButton(
                            onClick = {
                                navController.navigate(
                                    route = AppDestination.Settings.route
                                ) {
                                    launchSingleTop = true
                                }
                            }
                        ) {
                            Icon(
                                imageVector = Icons.Default.Settings,
                                contentDescription = "Open settings"
                            )
                        }
                    }
                }
            )
        },

        bottomBar = {
            if (showBottomBar) {
                NavigationBar {
                    bottomNavigationItems.forEach { item ->
                        val selected =
                            currentDestination?.hierarchy?.any { destination ->
                                destination.route == item.destination.route
                            } == true

                        NavigationBarItem(
                            selected = selected,

                            onClick = {
                                navController.navigate(
                                    route = item.destination.route
                                ) {
                                    popUpTo(AppDestination.Home.route) {
                                        saveState = true
                                    }

                                    launchSingleTop = true
                                    restoreState = true
                                }
                            },

                            icon = {
                                Icon(
                                    imageVector = item.icon,
                                    contentDescription = item.destination.title
                                )
                            },

                            label = {
                                Text(text = item.destination.title)
                            },

                            colors = NavigationBarItemDefaults.colors()
                        )
                    }
                }
            }
        }
    ) { innerPadding ->
        AppNavGraph(
            navController = navController,
            modifier = Modifier.padding(innerPadding)
        )
    }
}