package com.example.mathgame.presentation.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mathgame.databinding.ActivityMainBinding
import com.example.mathgame.presentation.listeners.GameModeButtonListener

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.additionButton.setOnClickListener(GameModeButtonListener(this@MainActivity, "Addition"))
        binding.subtractionButton.setOnClickListener(GameModeButtonListener(this@MainActivity, "Subtraction"))
        binding.multiplicationButton.setOnClickListener(GameModeButtonListener(this@MainActivity, "Multiplication"))
    }
}