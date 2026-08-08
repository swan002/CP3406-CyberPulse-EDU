package au.edu.jcu.cyberpulseedu.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import au.edu.jcu.cyberpulseedu.ui.home.HomeScreen
import au.edu.jcu.cyberpulseedu.ui.learn.LearnScreen
import au.edu.jcu.cyberpulseedu.ui.learn.LessonDetailScreen
import au.edu.jcu.cyberpulseedu.ui.quiz.QuizQuestionScreen
import au.edu.jcu.cyberpulseedu.ui.quiz.QuizResultScreen
import au.edu.jcu.cyberpulseedu.ui.quiz.QuizScreen
import au.edu.jcu.cyberpulseedu.ui.quiz.QuizViewModel
import au.edu.jcu.cyberpulseedu.ui.settings.SettingsScreen
import au.edu.jcu.cyberpulseedu.ui.statistics.StatisticsScreen

@Composable
fun AppNavGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    startDestination: String =
        AppDestination.Home.route
) {
    val quizViewModel: QuizViewModel =
        viewModel()

    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {

        composable(
            route = AppDestination.Home.route
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
            route = AppDestination.Learn.route
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
            route = AppDestination.LessonDetail.route,
            arguments = listOf(
                navArgument(
                    AppDestination
                        .LessonDetail
                        .ARG_LESSON_ID
                ) {
                    type = NavType.IntType
                }
            )
        ) { backStackEntry ->

            val lessonId =
                backStackEntry.arguments
                    ?.getInt(
                        AppDestination
                            .LessonDetail
                            .ARG_LESSON_ID
                    )

            if (lessonId != null) {

                LessonDetailScreen(
                    lessonId = lessonId,
                    onBackClick = {
                        navController.popBackStack()
                    },
                    onStartQuiz = {
                        navController.navigate(
                            AppDestination.Quiz.route
                        )
                    }
                )
            }
        }

        composable(
            route = AppDestination.Quiz.route
        ) {

            QuizScreen(
                onStartQuiz = {
                        topic,
                        difficulty,
                        questionCount ->

                    quizViewModel.startQuiz(
                        topic = topic,
                        difficulty = difficulty,
                        questionCount = questionCount
                    )

                    navController.navigate(
                        AppDestination.QuizPlay.route
                    )
                }
            )
        }

        composable(
            route = AppDestination.QuizPlay.route
        ) {

            val state by
            quizViewModel.uiState
                .collectAsState()

            val question =
                state.currentQuestion

            if (
                question != null &&
                !state.quizFinished
            ) {

                QuizQuestionScreen(
                    question = question,
                    currentQuestionIndex =
                        state.currentQuestionIndex,
                    totalQuestions =
                        state.questions.size,
                    selectedAnswerIndex =
                        state.selectedAnswerIndex,
                    answerSubmitted =
                        state.answerSubmitted,
                    onAnswerSelected = {
                            answerIndex ->

                        quizViewModel
                            .selectAnswer(
                                answerIndex
                            )
                    },
                    onSubmitAnswer = {
                        quizViewModel
                            .submitAnswer()
                    },
                    onNextQuestion = {

                        val wasLastQuestion =
                            state.currentQuestionIndex ==
                                    state.questions.lastIndex

                        quizViewModel
                            .nextQuestion()

                        if (wasLastQuestion) {
                            navController.navigate(
                                AppDestination
                                    .QuizResult
                                    .route
                            )
                        }
                    }
                )

            } else {

                TextFallback(
                    text =
                        "No quiz questions are available for this selection."
                )
            }
        }

        composable(
            route = AppDestination.QuizResult.route
        ) {

            val result =
                quizViewModel
                    .getResult()

            QuizResultScreen(
                result = result,

                onTryAgain = {

                    quizViewModel
                        .resetQuiz()

                    navController.navigate(
                        AppDestination
                            .Quiz
                            .route
                    ) {
                        popUpTo(
                            AppDestination
                                .Quiz
                                .route
                        ) {
                            inclusive = true
                        }
                    }
                },

                onReturnHome = {

                    quizViewModel
                        .resetQuiz()

                    navController.navigate(
                        AppDestination
                            .Home
                            .route
                    ) {
                        popUpTo(
                            AppDestination
                                .Home
                                .route
                        ) {
                            inclusive = false
                        }

                        launchSingleTop = true
                    }
                }
            )
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

@Composable
private fun TextFallback(
    text: String
) {
    androidx.compose.material3.Text(
        text = text
    )
}