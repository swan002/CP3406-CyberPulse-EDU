package au.edu.jcu.cyberpulseedu.domain.model

data class QuizResult(
    val topic: String,
    val difficulty: LessonDifficulty,
    val totalQuestions: Int,
    val correctAnswers: Int
) {
    val incorrectAnswers: Int
        get() = totalQuestions - correctAnswers

    val percentage: Int
        get() {
            if (totalQuestions == 0) {
                return 0
            }

            return ((correctAnswers.toFloat() / totalQuestions.toFloat()) * 100).toInt()
        }
}