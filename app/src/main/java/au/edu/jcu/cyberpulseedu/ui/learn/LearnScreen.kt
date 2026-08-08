package au.edu.jcu.cyberpulseedu.ui.learn

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import au.edu.jcu.cyberpulseedu.data.repository.LessonRepository
import au.edu.jcu.cyberpulseedu.domain.model.LessonDifficulty
import au.edu.jcu.cyberpulseedu.ui.components.LessonCard

@Composable
fun LearnScreen(
    onLessonClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    var searchQuery by rememberSaveable {
        mutableStateOf("")
    }

    var selectedDifficulty by rememberSaveable {
        mutableStateOf<LessonDifficulty?>(null)
    }

    val lessons = remember {
        LessonRepository.getLessons()
    }

    val filteredLessons = remember(
        lessons,
        searchQuery,
        selectedDifficulty
    ) {
        lessons.filter { lesson ->

            val matchesSearch =
                lesson.title.contains(
                    searchQuery,
                    ignoreCase = true
                ) ||
                        lesson.category.contains(
                            searchQuery,
                            ignoreCase = true
                        ) ||
                        lesson.summary.contains(
                            searchQuery,
                            ignoreCase = true
                        )

            val matchesDifficulty =
                selectedDifficulty == null ||
                        lesson.difficulty == selectedDifficulty

            matchesSearch && matchesDifficulty
        }
    }

    Column(
        modifier = modifier.fillMaxSize()
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 20.dp,
                    end = 20.dp,
                    top = 20.dp,
                    bottom = 12.dp
                ),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            Column(
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(
                    text = "Cybersecurity Lessons",
                    style = MaterialTheme.typography.headlineMedium
                )

                Text(
                    text = "Build practical security awareness through short, focused lessons.",
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            OutlinedTextField(
                value = searchQuery,
                onValueChange = {
                    searchQuery = it
                },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                label = {
                    Text("Search lessons")
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = null
                    )
                }
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .horizontalScroll(
                        rememberScrollState()
                    ),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {

                FilterChip(
                    selected = selectedDifficulty == null,
                    onClick = {
                        selectedDifficulty = null
                    },
                    label = {
                        Text("All")
                    }
                )

                LessonDifficulty.entries.forEach { difficulty ->

                    FilterChip(
                        selected = selectedDifficulty == difficulty,
                        onClick = {
                            selectedDifficulty = difficulty
                        },
                        label = {
                            Text(
                                difficulty.displayName
                            )
                        }
                    )
                }
            }
        }

        if (filteredLessons.isEmpty()) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(32.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = "No lessons found",
                    style = MaterialTheme.typography.titleMedium
                )

                Text(
                    text = "Try changing your search or difficulty filter.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

        } else {

            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(
                    start = 20.dp,
                    end = 20.dp,
                    top = 4.dp,
                    bottom = 24.dp
                ),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                items(
                    items = filteredLessons,
                    key = { lesson ->
                        lesson.id
                    }
                ) { lesson ->

                    LessonCard(
                        lesson = lesson,
                        onClick = {
                            onLessonClick(
                                lesson.id
                            )
                        }
                    )
                }
            }
        }
    }
}