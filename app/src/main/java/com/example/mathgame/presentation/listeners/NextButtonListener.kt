package com.example.mathgame.presentation.listeners

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.View
import android.widget.Toast
import com.example.mathgame.databinding.ActivityGameBinding
import com.example.mathgame.domain.entities.classes.CustomTimer
import com.example.mathgame.domain.entities.classes.QuestionGenerator
import com.example.mathgame.domain.entities.classes.UserStats
import com.example.mathgame.presentation.activities.ResultActivity

class NextButtonListener(
    private val binding: ActivityGameBinding,
    private val context: Context,
    private val mode: String
) : View.OnClickListener {
    override fun onClick(view: View?) {
        CustomTimer.pauseTimer()
        CustomTimer.resetTimer(binding.textViewTime)

        QuestionGenerator.generateQuestion(binding, mode)
        binding.editTextAnswer.setText("")

        if (UserStats.lives == 0) {
            Toast.makeText(context, "Game over", Toast.LENGTH_LONG).show()

            val intent = Intent(context, ResultActivity::class.java)
            context.startActivity(intent)
            (context as Activity).finish()
        } else {
            QuestionGenerator.generateQuestion(binding, mode)
        }
    }
}