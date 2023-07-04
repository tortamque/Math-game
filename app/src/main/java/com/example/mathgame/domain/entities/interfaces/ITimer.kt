package com.example.mathgame.domain.entities.interfaces

import android.os.CountDownTimer
import android.widget.TextView
import com.example.mathgame.domain.entities.classes.CustomTimer
import com.example.mathgame.domain.entities.classes.UserStats
import java.util.Locale

interface ITimer {
    fun startTimer(textViewLive: TextView, textViewQuestion: TextView, textViewTime: TextView)
    fun updateText(textViewTime: TextView)
    fun pauseTimer()
    fun resetTimer(textViewTime: TextView)
}