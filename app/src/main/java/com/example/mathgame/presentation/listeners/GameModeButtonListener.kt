package com.example.mathgame.presentation.listeners

import android.content.Context
import android.content.Intent
import android.view.View
import com.example.mathgame.presentation.activities.GameActivity

class GameModeButtonListener(
    private val context: Context,
    private val mode: String
) : View.OnClickListener{
    override fun onClick(view: View?) {
        val intent = Intent(context, GameActivity::class.java)
        intent.putExtra("mode", mode)

        context.startActivity(intent)
    }
}