package com.example.mathgame.domain.entities.classes

import android.os.CountDownTimer
import android.widget.TextView
import com.example.mathgame.domain.entities.interfaces.ITimer
import java.util.Locale

object CustomTimer : ITimer {
    private lateinit var timer: CountDownTimer
    private val startTimerInMillis: Long = 21 * 1000
    private var timeLeftInMillis: Long = startTimerInMillis
    private var isTimerRunning: Boolean = false

    override fun startTimer(textViewLive: TextView, textViewQuestion: TextView, textViewTime: TextView) {
        if (isTimerRunning) {
            pauseTimer()
        }

        timer = object : CountDownTimer(timeLeftInMillis, 1000) {
            override fun onTick(remainingTimeInMillis: Long) {
                timeLeftInMillis = remainingTimeInMillis
                updateText(textViewTime)
            }

            override fun onFinish() {
                pauseTimer()
                resetTimer(textViewTime)
                updateText(textViewTime)

                UserStats.updateLives()

                textViewLive.text = UserStats.lives.toString()
                textViewQuestion.text = "Your time is out"
            }
        }.start()

        isTimerRunning = true
    }

    override fun updateText(textViewTime: TextView) {
        val remainingTime: Int = (timeLeftInMillis / 1000).toInt()

        textViewTime.text = String.format(Locale.getDefault(), "%02d", remainingTime)
    }

    override fun pauseTimer() {
        timer.cancel()
        isTimerRunning = false
    }

    override fun resetTimer(textViewTime: TextView) {
        timeLeftInMillis = startTimerInMillis
        updateText(textViewTime)
    }
}
