package com.example.androiddevpractice.topics.userinterface.snackbar

import android.util.Log
import android.view.View

class SnackbarAction : View.OnClickListener {

    override fun onClick(v: View) {
        Log.i("PracticeSnackbarAction", "onClick")
    }
}