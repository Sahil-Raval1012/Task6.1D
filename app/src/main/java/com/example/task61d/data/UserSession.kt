package com.example.task61d.data

object UserSession {
    var username: String = "Student"
    var email: String = ""
    var interests: MutableList<String> = mutableListOf()
    var lastResults: List<AnswerResult> = emptyList()
    var lastTask: LearningTask? = null
}
