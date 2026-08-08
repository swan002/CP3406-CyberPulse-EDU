package au.edu.jcu.cyberpulseedu.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import au.edu.jcu.cyberpulseedu.ui.home.HomeScreen
import au.edu.jcu.cyberpulseedu.ui.learn.LearnScreen
import au.edu.jcu.cyberpulseedu.ui.learn.LessonDetailScreen
import au.edu.jcu.cyberpulseedu.ui.quiz.QuizScreen
import au.edu.jcu.cyberpulseedu.ui.settings.SettingsScreen
import au.edu.jcu.cyberpulseedu.ui.statistics.StatisticsScreen

@Composable
fun AppNavGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    startDestination: String =
        AppDestination.Home.route
) {

    NavHost(
        navController = navController,
        startDestination =
            startDestination,
        modifier = modifier
    ) {

        composable(
            route =
                AppDestination.Home.route
        ) {

            HomeScreen(
                onLearnClick = {
                    navController.navigate(
                        AppDestination.Learn.route
                    )
                },
                onQuizClick = {
                    navController.navigate(
                        AppDestination.Quiz.route
                    )
                },
                onStatisticsClick = {
                    navController.navigate(
                        AppDestination.Statistics.route
                    )
                }
            )
        }

        composable(
            route =
                AppDestination.Learn.route
        ) {

            LearnScreen(
                onLessonClick = { lessonId ->

                    navController.navigate(
                        AppDestination
                            .LessonDetail
                            .createRoute(
                                lessonId
                            )
                    )
                }
            )
        }

        composable(
            route =
                AppDestination.LessonDetail.route,
            arguments = listOf(
                navArgument(
                    AppDestination
                        .LessonDetail
                        .ARG_LESSON_ID
                ) {
                    type =
                        NavType.IntType
                }
            )
        ) { backStackEntry ->

            val lessonId =
                backStackEntry
                    .arguments
                    ?.getInt(
                        AppDestination
                            .LessonDetail
                            .ARG_LESSON_ID
                    )

            if (lessonId != null) {

                LessonDetailScreen(
                    lessonId =
                        lessonId,
                    onBackClick = {
                        navController
                            .popBackStack()
                    },
                    onStartQuiz = {
                        navController.navigate(
                            AppDestination
                                .Quiz
                                .route
                        )
                    }
                )
            }
        }

        composable(
            route =
                AppDestination.Quiz.route
        ) {
            QuizScreen()
        }

        composable(
            route =
                AppDestination.Statistics.route
        ) {
            StatisticsScreen()
        }

        composable(
            route =
                AppDestination.Settings.route
        ) {
            SettingsScreen()
        }
    }
}