package com.example.mathgame.domain.entities.classes

import com.example.mathgame.databinding.ActivityGameBinding
import kotlin.random.Random

object QuestionGenerator {
    fun generateQuestion(binding: ActivityGameBinding, mode: String){
        var number1 = 0
        var number2 = 0

        if(mode == "Addition"){
            number1 = Random.nextInt(0, 200)
            number2 = Random.nextInt(0, 200)

            binding.textViewQuestion.text = "$number1 + $number2"

            Answer.answer = number1 + number2
        } else if (mode == "Subtraction"){
            number1 = Random.nextInt(0, 200)
            number2 = Random.nextInt(0, 200)

            binding.textViewQuestion.text = "$number1 - $number2"

            Answer.answer = number1 - number2
        } else{
            number1 = Random.nextInt(0, 20)
            number2 = Random.nextInt(0, 20)

            binding.textViewQuestion.text = "$number1 * $number2"

            Answer.answer = number1 * number2
        }

        CustomTimer.startTimer(binding.textViewLive, binding.textViewQuestion, binding.textViewTime)
    }
}