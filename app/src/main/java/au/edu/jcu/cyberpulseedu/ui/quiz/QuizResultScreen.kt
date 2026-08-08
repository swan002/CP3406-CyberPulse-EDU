package au.edu.jcu.cyberpulseedu.ui.quiz

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import au.edu.jcu.cyberpulseedu.domain.model.QuizResult

@Composable
fun QuizResultScreen(
    result: QuizResult,
    onTryAgain: () -> Unit,
    onReturnHome: () -> Unit,
    modifier: Modifier = Modifier
) {
    val feedback =
        when {
            result.percentage >= 90 ->
                "Excellent cybersecurity awareness."

            result.percentage >= 75 ->
                "Strong result. Keep building your knowledge."

            result.percentage >= 50 ->
                "Good progress. Review the topics you missed."

            else ->
                "Review the lessons and try again."
        }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {

        Text(
            text = "Quiz Complete",
            style = MaterialTheme.typography.headlineMedium
        )

        Text(
            text = "${result.percentage}%",
            style = MaterialTheme.typography.displayMedium,
            color = MaterialTheme.colorScheme.primary
        )

        Text(
            text = feedback,
            style = MaterialTheme.typography.bodyLarge
        )

        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor =
                    MaterialTheme.colorScheme.surfaceContainer
            )
        ) {

            Column(
                modifier = Modifier.padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {

                Text(
                    text = "Results",
                    style = MaterialTheme.typography.titleLarge
                )

                Text(
                    text = "Topic: ${result.topic}"
                )

                Text(
                    text = "Difficulty: ${result.difficulty.displayName}"
                )

                Text(
                    text = "Correct answers: ${result.correctAnswers}"
                )

                Text(
                    text = "Incorrect answers: ${result.incorrectAnswers}"
                )

                Text(
                    text = "Total questions: ${result.totalQuestions}"
                )
            }
        }

        Button(
            onClick = onTryAgain,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Try Again")
        }

        OutlinedButton(
            onClick = onReturnHome,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Return Home")
        }
    }
}