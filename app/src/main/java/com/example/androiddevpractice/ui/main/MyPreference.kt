package com.example.androiddevpractice.ui.main

import android.content.SharedPreferences
import android.util.Log

class MyPreference(private val sharedPreferences: SharedPreferences) {

    private val TAG = "PracMyPreference"

    fun saveUserPreferences(theme: Int, darkMode: Int) {
        with(sharedPreferences.edit()) {
            putInt(KEY_THEME, theme)
            putInt(KEY_DARK_MODE, darkMode)
            commit()
        }
    }

    fun getSavedTheme(): Int {
        val savedTheme = sharedPreferences.getInt(KEY_THEME, 0)
        Log.i(TAG, "savedTheme: $savedTheme")
        return savedTheme
    }

    fun getDarkModeState(): Int {
        val darkModeState = sharedPreferences.getInt(KEY_DARK_MODE, 0)
        Log.i(TAG, "darkModeState: $darkModeState")
        return darkModeState
    }
}