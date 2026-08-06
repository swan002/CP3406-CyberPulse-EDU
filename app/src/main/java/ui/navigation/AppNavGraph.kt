package au.edu.jcu.cyberpulseedu.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import au.edu.jcu.cyberpulseedu.ui.home.HomeScreen
import au.edu.jcu.cyberpulseedu.ui.learn.LearnScreen
import au.edu.jcu.cyberpulseedu.ui.quiz.QuizScreen
import au.edu.jcu.cyberpulseedu.ui.settings.SettingsScreen
import au.edu.jcu.cyberpulseedu.ui.statistics.StatisticsScreen

@Composable
fun AppNavGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    startDestination: String = AppDestination.Home.route
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(route = AppDestination.Home.route) {
            HomeScreen()
        }

        composable(route = AppDestination.Learn.route) {
            LearnScreen()
        }

        composable(route = AppDestination.Quiz.route) {
            QuizScreen()
        }

        composable(route = AppDestination.Statistics.route) {
            StatisticsScreen()
        }

        composable(route = AppDestination.Settings.route) {
            SettingsScreen()
        }
    }
}