package com.example.mathgame.domain.entities.interfaces

interface IUserStats {
    fun updateScore()
    fun updateLives()
    fun resetScore()
    fun resetLives()
}