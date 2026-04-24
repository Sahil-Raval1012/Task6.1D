package com.example.task61d.data

data class Question(
    val text: String,
    val options: List<String>,
    val correctIndex: Int
)

data class LearningTask(
    val id: Int,
    val title: String,
    val description: String,
    val topic: String,
    val questions: List<Question>
)

data class AnswerResult(
    val question: Question,
    val selectedIndex: Int
) {
    val isCorrect: Boolean get() = selectedIndex == question.correctIndex
}
