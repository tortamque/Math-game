package com.example.mathgame.presentation.listeners

import android.app.Activity
import android.content.Intent
import android.view.View
import com.example.mathgame.domain.entities.classes.UserStats
import com.example.mathgame.presentation.activities.MainActivity

class PlayAgainButtonListener : View.OnClickListener {
    override fun onClick(view: View?) {
        UserStats.reset()

        val intent = Intent(view?.context, MainActivity::class.java)
        view?.context?.startActivity(intent)
        (view?.context as? Activity)?.finish()
    }
}