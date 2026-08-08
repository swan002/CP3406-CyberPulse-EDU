package au.edu.jcu.cyberpulseedu.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BarChart
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.Quiz
import androidx.compose.material.icons.filled.Security
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import au.edu.jcu.cyberpulseedu.ui.components.LearningProgressCard
import au.edu.jcu.cyberpulseedu.ui.components.QuickActionCard
import au.edu.jcu.cyberpulseedu.ui.components.SectionHeader

@Composable
fun HomeScreen(
    onLearnClick: () -> Unit,
    onQuizClick: () -> Unit,
    onStatisticsClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {

        Column(
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(
                text = "Welcome back",
                style = MaterialTheme.typography.headlineMedium
            )

            Text(
                text = "Continue building your cybersecurity awareness.",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }

        LearningProgressCard(
            completedLessons = 5,
            totalLessons = 8
        )

        Column(
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            SectionHeader(
                title = "Continue Learning"
            )

            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surfaceContainer
                )
            ) {
                Column(
                    modifier = Modifier.padding(20.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Text(
                        text = "Phishing Awareness",
                        style = MaterialTheme.typography.titleLarge
                    )

                    Text(
                        text = "Learn how to recognise suspicious emails, links and login pages.",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )

                    Text(
                        text = "Estimated time: 4 minutes",
                        style = MaterialTheme.typography.labelLarge,
                        color = MaterialTheme.colorScheme.primary
                    )

                    Button(
                        onClick = onLearnClick
                    ) {
                        Text("Continue Lesson")
                    }
                }
            }
        }

        Column(
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            SectionHeader(
                title = "Daily Challenge"
            )

            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.secondaryContainer
                )
            ) {
                Column(
                    modifier = Modifier.padding(20.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    androidx.compose.material3.Icon(
                        imageVector = Icons.Default.Security,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.secondary
                    )

                    Text(
                        text = "Can you identify a phishing attempt?",
                        style = MaterialTheme.typography.titleMedium
                    )

                    Text(
                        text = "Test your ability to recognise common warning signs in suspicious messages.",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSecondaryContainer
                    )

                    Button(
                        onClick = onQuizClick
                    ) {
                        Text("Start Challenge")
                    }
                }
            }
        }

        Column(
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            SectionHeader(
                title = "Quick Actions"
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                QuickActionCard(
                    title = "Learn",
                    description = "Explore lessons",
                    icon = Icons.Default.MenuBook,
                    onClick = onLearnClick,
                    modifier = Modifier.weight(1f)
                )

                QuickActionCard(
                    title = "Quiz",
                    description = "Test yourself",
                    icon = Icons.Default.Quiz,
                    onClick = onQuizClick,
                    modifier = Modifier.weight(1f)
                )
            }

            QuickActionCard(
                title = "Statistics",
                description = "View your learning progress and quiz performance",
                icon = Icons.Default.BarChart,
                onClick = onStatisticsClick
            )
        }

        Column(
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            SectionHeader(
                title = "Latest Cyber News"
            )

            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surfaceContainer
                )
            ) {
                Column(
                    modifier = Modifier.padding(20.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = "Cybersecurity News",
                        style = MaterialTheme.typography.labelLarge,
                        color = MaterialTheme.colorScheme.primary
                    )

                    Text(
                        text = "Live cybersecurity stories will appear here.",
                        style = MaterialTheme.typography.titleMedium
                    )

                    Text(
                        text = "Later, this section will use Retrofit to retrieve current cybersecurity news and connect each story to a learning topic.",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }
    }
}