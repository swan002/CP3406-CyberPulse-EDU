package au.edu.jcu.cyberpulseedu.ui.quiz

import androidx.lifecycle.ViewModel
import au.edu.jcu.cyberpulseedu.data.repository.QuizRepository
import au.edu.jcu.cyberpulseedu.domain.model.LessonDifficulty
import au.edu.jcu.cyberpulseedu.domain.model.QuizQuestion
import au.edu.jcu.cyberpulseedu.domain.model.QuizResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class QuizUiState(
    val questions: List<QuizQuestion> = emptyList(),
    val currentQuestionIndex: Int = 0,
    val selectedAnswerIndex: Int? = null,
    val answerSubmitted: Boolean = false,
    val correctAnswers: Int = 0,
    val topic: String = "All Topics",
    val difficulty: LessonDifficulty = LessonDifficulty.BEGINNER,
    val quizFinished: Boolean = false
) {
    val currentQuestion: QuizQuestion?
        get() = questions.getOrNull(currentQuestionIndex)
}

class QuizViewModel : ViewModel() {

    private val _uiState =
        MutableStateFlow(
            QuizUiState()
        )

    val uiState: StateFlow<QuizUiState> =
        _uiState.asStateFlow()

    fun startQuiz(
        topic: String,
        difficulty: LessonDifficulty?,
        questionCount: Int
    ) {
        val effectiveDifficulty =
            difficulty ?: LessonDifficulty.BEGINNER

        val questions =
            QuizRepository.getQuestions(
                topic = topic,
                difficulty = difficulty,
                questionCount = questionCount
            )

        _uiState.value =
            QuizUiState(
                questions = questions,
                topic = topic,
                difficulty = effectiveDifficulty
            )
    }

    fun selectAnswer(
        answerIndex: Int
    ) {
        if (_uiState.value.answerSubmitted) {
            return
        }

        _uiState.value =
            _uiState.value.copy(
                selectedAnswerIndex = answerIndex
            )
    }

    fun submitAnswer() {

        val state = _uiState.value

        val question =
            state.currentQuestion
                ?: return

        val selectedAnswer =
            state.selectedAnswerIndex
                ?: return

        val correct =
            selectedAnswer ==
                    question.correctAnswerIndex

        _uiState.value =
            state.copy(
                answerSubmitted = true,
                correctAnswers =
                    state.correctAnswers +
                            if (correct) 1 else 0
            )
    }

    fun nextQuestion() {

        val state = _uiState.value

        val isLastQuestion =
            state.currentQuestionIndex >=
                    state.questions.lastIndex

        if (isLastQuestion) {

            _uiState.value =
                state.copy(
                    quizFinished = true
                )

        } else {

            _uiState.value =
                state.copy(
                    currentQuestionIndex =
                        state.currentQuestionIndex + 1,
                    selectedAnswerIndex = null,
                    answerSubmitted = false
                )
        }
    }

    fun getResult(): QuizResult {

        val state = _uiState.value

        return QuizResult(
            topic = state.topic,
            difficulty = state.difficulty,
            totalQuestions =
                state.questions.size,
            correctAnswers =
                state.correctAnswers
        )
    }

    fun resetQuiz() {

        _uiState.value =
            QuizUiState()
    }
}