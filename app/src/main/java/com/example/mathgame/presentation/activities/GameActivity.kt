package com.example.mathgame.presentation.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mathgame.databinding.ActivityGameBinding
import com.example.mathgame.domain.entities.classes.QuestionGenerator
import com.example.mathgame.presentation.listeners.NextButtonListener
import com.example.mathgame.presentation.listeners.OKButtonListener

class GameActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGameBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        val mode: String = intent.getStringExtra("mode")!!

        super.onCreate(savedInstanceState)
        binding = ActivityGameBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        supportActionBar!!.title = mode

        QuestionGenerator.generateQuestion(binding, mode)

        binding.buttonOK.setOnClickListener(
            OKButtonListener(this@GameActivity, binding)
        )

        binding.buttonNext.setOnClickListener(
            NextButtonListener(binding, this@GameActivity, mode)
        )
    }
}