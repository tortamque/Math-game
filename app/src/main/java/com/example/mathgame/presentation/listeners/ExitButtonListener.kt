package com.example.mathgame.presentation.listeners

import android.content.Intent
import android.view.View

class ExitButtonListener: View.OnClickListener {
    override fun onClick(view: View?) {
        val intent = Intent(Intent.ACTION_MAIN)
        intent.addCategory(Intent.CATEGORY_HOME)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        view?.context?.startActivity(intent)
    }
}