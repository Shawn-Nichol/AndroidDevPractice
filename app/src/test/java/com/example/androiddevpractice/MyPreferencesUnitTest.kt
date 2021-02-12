package com.example.androiddevpractice

import android.content.SharedPreferences
import com.example.androiddevpractice.ui.KEY_DARK_MODE
import com.example.androiddevpractice.ui.KEY_THEME
import com.example.androiddevpractice.ui.MyPreference
import com.nhaarman.mockitokotlin2.inOrder
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import org.junit.Assert
import org.junit.Test

class MyPreferencesUnitTest {




    @Test
    fun myPreferences_SavePreferences() {
        val sharedPreferencesEditor: SharedPreferences.Editor = mock()
        val sharedPreferences: SharedPreferences = mock()
        whenever(sharedPreferences.edit()).thenReturn(sharedPreferencesEditor)

        val loadTheme = MyPreference(sharedPreferences)
        loadTheme.saveUserPreferences(1, 1)


        inOrder(sharedPreferencesEditor) {
            verify(sharedPreferencesEditor).putInt(KEY_THEME, 1)
            verify(sharedPreferencesEditor).putInt(KEY_DARK_MODE, 1)
            verify(sharedPreferencesEditor).commit()
        }
    }

    @Test
    fun myPreferences_loadTheme() {
        val sharedPreferencesEditor: SharedPreferences.Editor = mock()
        val sharedPreferences: SharedPreferences = mock()

        whenever(sharedPreferences.edit()).thenReturn(sharedPreferencesEditor)

        val myPreference = MyPreference(sharedPreferences)
        myPreference.saveUserPreferences(1, 1)

        val theme = myPreference.getSavedTheme()

        Assert.assertEquals(1, theme)

    }


}