package com.example.androiddevpractice.ui

import android.content.SharedPreferences

class MyPreference(private val sharedPreferences: SharedPreferences) {

    fun saveUserPreferences(theme: Int, darkMode: Int) {
        with(sharedPreferences.edit()) {
            putInt(com.example.androiddevpractice.ui.KEY_THEME, theme)
            putInt(com.example.androiddevpractice.ui.KEY_DARK_MODE, darkMode)
            commit()
        }
    }

    fun getSavedTheme(): Int {
        return sharedPreferences.getInt(KEY_THEME, 0)
    }

    fun getDarkModeState(): Int {
        return sharedPreferences.getInt(KEY_DARK_MODE, 0)
    }
}