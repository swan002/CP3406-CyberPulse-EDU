package au.edu.jcu.cyberpulseedu.domain.model

data class QuizQuestion(
    val id: Int,
    val topic: String,
    val difficulty: LessonDifficulty,
    val question: String,
    val options: List<String>,
    val correctAnswerIndex: Int,
    val explanation: String
)