package au.edu.jcu.cyberpulseedu.ui.quiz

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import au.edu.jcu.cyberpulseedu.data.repository.QuizRepository
import au.edu.jcu.cyberpulseedu.domain.model.LessonDifficulty

@Composable
fun QuizScreen(
    onStartQuiz: (
        topic: String,
        difficulty: LessonDifficulty?,
        questionCount: Int
    ) -> Unit,
    modifier: Modifier = Modifier
) {
    val topics = QuizRepository.getTopics()

    var selectedTopic by rememberSaveable {
        mutableStateOf("All Topics")
    }

    var selectedDifficulty by rememberSaveable {
        mutableStateOf<LessonDifficulty?>(null)
    }

    var questionCount by rememberSaveable {
        mutableIntStateOf(5)
    }

    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(20.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {

        item {
            Column(
                verticalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                Text(
                    text = "Cybersecurity Quiz",
                    style = MaterialTheme.typography.headlineMedium
                )

                Text(
                    text = "Choose a topic and difficulty, then test your cybersecurity awareness.",
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }

        item {
            Text(
                text = "Choose Topic",
                style = MaterialTheme.typography.titleLarge
            )
        }

        items(
            items = topics,
            key = { topic -> topic }
        ) { topic ->

            FilterChip(
                selected = selectedTopic == topic,
                onClick = {
                    selectedTopic = topic
                },
                label = {
                    Text(topic)
                }
            )
        }

        item {
            Text(
                text = "Difficulty",
                style = MaterialTheme.typography.titleLarge
            )
        }

        item {
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {

                FilterChip(
                    selected = selectedDifficulty == null,
                    onClick = {
                        selectedDifficulty = null
                    },
                    label = {
                        Text("Any Difficulty")
                    }
                )

                LessonDifficulty.entries.forEach { difficulty ->

                    FilterChip(
                        selected = selectedDifficulty == difficulty,
                        onClick = {
                            selectedDifficulty = difficulty
                        },
                        label = {
                            Text(difficulty.displayName)
                        }
                    )
                }
            }
        }

        item {
            Text(
                text = "Number of Questions",
                style = MaterialTheme.typography.titleLarge
            )
        }

        item {
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                listOf(5, 10).forEach { count ->

                    FilterChip(
                        selected = questionCount == count,
                        onClick = {
                            questionCount = count
                        },
                        label = {
                            Text("$count Questions")
                        }
                    )
                }
            }
        }

        item {
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor =
                        MaterialTheme.colorScheme.secondaryContainer
                )
            ) {
                Column(
                    modifier = Modifier.padding(18.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = "Quiz Summary",
                        style = MaterialTheme.typography.titleMedium
                    )

                    Text(
                        text = "Topic: $selectedTopic"
                    )

                    Text(
                        text = "Difficulty: ${
                            selectedDifficulty?.displayName
                                ?: "Any"
                        }"
                    )

                    Text(
                        text = "Questions: $questionCount"
                    )
                }
            }
        }

        item {
            Button(
                onClick = {
                    onStartQuiz(
                        selectedTopic,
                        selectedDifficulty,
                        questionCount
                    )
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Start Quiz")
            }
        }
    }
}