package com.example.mathgame.domain.entities.classes

object AnswerChecker {
    fun checkAnswer(userAnswer: Int): Boolean {
        return userAnswer == Answer.answer
    }
}