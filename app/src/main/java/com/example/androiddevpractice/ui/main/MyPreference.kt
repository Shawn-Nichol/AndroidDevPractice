package com.example.androiddevpractice.ui.main

import android.content.SharedPreferences

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
        return sharedPreferences.getInt(KEY_THEME, 0)
    }

    fun getDarkModeState(): Int {
        return  sharedPreferences.getInt(KEY_DARK_MODE, 0)
    }
}