package au.edu.jcu.cyberpulseedu.ui.quiz

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Cancel
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import au.edu.jcu.cyberpulseedu.domain.model.QuizQuestion

@Composable
fun QuizQuestionScreen(
    question: QuizQuestion,
    currentQuestionIndex: Int,
    totalQuestions: Int,
    selectedAnswerIndex: Int?,
    answerSubmitted: Boolean,
    onAnswerSelected: (Int) -> Unit,
    onSubmitAnswer: () -> Unit,
    onNextQuestion: () -> Unit,
    modifier: Modifier = Modifier
) {
    val progress =
        if (totalQuestions > 0) {
            (currentQuestionIndex + 1).toFloat() / totalQuestions.toFloat()
        } else {
            0f
        }

    val isCorrect =
        selectedAnswerIndex == question.correctAnswerIndex

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {

        Text(
            text = "Question ${currentQuestionIndex + 1} of $totalQuestions",
            style = MaterialTheme.typography.labelLarge,
            color = MaterialTheme.colorScheme.primary
        )

        LinearProgressIndicator(
            progress = { progress },
            modifier = Modifier.fillMaxWidth()
        )

        Text(
            text = question.topic,
            style = MaterialTheme.typography.labelLarge,
            color = MaterialTheme.colorScheme.secondary
        )

        Text(
            text = question.question,
            style = MaterialTheme.typography.headlineSmall
        )

        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {

            question.options.forEachIndexed { index, option ->

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable(
                            enabled = !answerSubmitted
                        ) {
                            onAnswerSelected(index)
                        },
                    colors = CardDefaults.cardColors(
                        containerColor =
                            if (
                                answerSubmitted &&
                                index == question.correctAnswerIndex
                            ) {
                                MaterialTheme.colorScheme.primaryContainer
                            } else if (
                                answerSubmitted &&
                                index == selectedAnswerIndex &&
                                index != question.correctAnswerIndex
                            ) {
                                MaterialTheme.colorScheme.errorContainer
                            } else {
                                MaterialTheme.colorScheme.surfaceContainer
                            }
                    )
                ) {

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(14.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        RadioButton(
                            selected = selectedAnswerIndex == index,
                            onClick = null,
                            enabled = !answerSubmitted
                        )

                        Text(
                            text = option,
                            modifier = Modifier
                                .weight(1f)
                                .padding(start = 8.dp),
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                }
            }
        }

        if (!answerSubmitted) {

            Button(
                onClick = onSubmitAnswer,
                enabled = selectedAnswerIndex != null,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Submit Answer")
            }

        } else {

            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor =
                        if (isCorrect) {
                            MaterialTheme.colorScheme.primaryContainer
                        } else {
                            MaterialTheme.colorScheme.errorContainer
                        }
                )
            ) {

                Column(
                    modifier = Modifier.padding(18.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {

                    Row(
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Icon(
                            imageVector =
                                if (isCorrect) {
                                    Icons.Default.CheckCircle
                                } else {
                                    Icons.Default.Cancel
                                },
                            contentDescription = null
                        )

                        Text(
                            text =
                                if (isCorrect) {
                                    "Correct"
                                } else {
                                    "Incorrect"
                                },
                            style = MaterialTheme.typography.titleMedium
                        )
                    }

                    Text(
                        text = question.explanation,
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }

            Button(
                onClick = onNextQuestion,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    if (
                        currentQuestionIndex ==
                        totalQuestions - 1
                    ) {
                        "View Results"
                    } else {
                        "Next Question"
                    }
                )
            }
        }
    }
}