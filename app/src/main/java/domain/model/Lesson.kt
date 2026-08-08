package au.edu.jcu.cyberpulseedu.domain.model

enum class LessonDifficulty(
    val displayName: String
) {
    BEGINNER("Beginner"),
    INTERMEDIATE("Intermediate"),
    ADVANCED("Advanced")
}

data class Lesson(
    val id: Int,
    val title: String,
    val category: String,
    val summary: String,
    val content: String,
    val securityTips: List<String>,
    val difficulty: LessonDifficulty,
    val estimatedMinutes: Int
)