package com.example.androiddevpractice.ui

import androidx.appcompat.app.AppCompatDelegate
import com.example.androiddevpractice.R

class LoadTheme() {

    /**
     * DarkMode = 1
     */
    fun setDarkMode(darkMode: Int) {
        AppCompatDelegate.setDefaultNightMode(darkMode)
    }

   fun setAppTheme(themeState: Int): Int  {
        return when(themeState) {
            1 -> {
                return R.style.AppTheme2
            }
            else -> R.style.AppTheme
        }
    }

}