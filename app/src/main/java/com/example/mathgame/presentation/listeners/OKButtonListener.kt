package com.example.mathgame.presentation.listeners

import android.content.Context
import android.view.View
import android.widget.Toast
import com.example.mathgame.databinding.ActivityGameBinding
import com.example.mathgame.domain.entities.classes.AnswerChecker
import com.example.mathgame.domain.entities.classes.CustomTimer
import com.example.mathgame.domain.entities.classes.LiveUpdater
import com.example.mathgame.domain.entities.classes.ScoreUpdater
import com.example.mathgame.domain.entities.classes.UserStats

class OKButtonListener(
    private val context: Context,
    private val binding: ActivityGameBinding,
) : View.OnClickListener {
    override fun onClick(view: View?) {
        val isEmpty = binding.editTextAnswer.text.toString().isEmpty()

        if(isEmpty){
            Toast.makeText(context, "Your answer is empty", Toast.LENGTH_SHORT).show()
        } else{
            CustomTimer.pauseTimer()

            val userAnswer = binding.editTextAnswer.text.toString().toInt()

            if (AnswerChecker.checkAnswer(userAnswer)){
                ScoreUpdater.updateScore()

                updateScoreUI()
                binding.textViewQuestion.text = "Answer is correct"
            } else{
                LiveUpdater.updateLives()

                updateLivesUI()
                binding.textViewQuestion.text = "Answer is wrong"
            }
        }
    }

    private fun updateScoreUI() {
        binding.textViewScore.text = UserStats.score.toString()
    }

    private fun updateLivesUI() {
        binding.textViewLive.text = UserStats.lives.toString()
    }
}
