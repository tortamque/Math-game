package com.example.mathgame.domain.entities.classes

import com.example.mathgame.domain.entities.interfaces.IUserStats

object UserStats: IUserStats {
    private var defaultLives = 3
    var score = 0
    private set
    var lives = defaultLives
    private set

    override fun updateScore(){
        score++
    }

    override fun updateLives(){
        if (lives >= 1){
            lives--
        }
    }

    override fun resetScore() {
        score = 0
    }

    override fun resetLives() {
        lives = defaultLives
    }

    fun reset(){
        resetScore()
        resetLives()
    }
}