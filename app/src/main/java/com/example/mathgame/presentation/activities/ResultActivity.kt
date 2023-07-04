package com.example.mathgame.presentation.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mathgame.databinding.ActivityResultBinding
import com.example.mathgame.domain.entities.classes.UserStats
import com.example.mathgame.presentation.listeners.ExitButtonListener
import com.example.mathgame.presentation.listeners.PlayAgainButtonListener

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.textViewResultScore.text = "Your score is: ${UserStats.score}"

        binding.buttonPlayAgain.setOnClickListener(PlayAgainButtonListener())
        binding.buttonExit.setOnClickListener(ExitButtonListener())
    }
}