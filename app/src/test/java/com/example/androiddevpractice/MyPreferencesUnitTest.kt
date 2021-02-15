package com.example.androiddevpractice

import android.content.SharedPreferences
import com.example.androiddevpractice.ui.main.KEY_DARK_MODE
import com.example.androiddevpractice.ui.main.KEY_THEME
import com.example.androiddevpractice.ui.main.MyPreference
import com.nhaarman.mockitokotlin2.inOrder
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MyPreferencesUnitTest {

    @Mock
    lateinit var sharedPreferences: SharedPreferences

    @Mock
    lateinit var sharedPreferencesEditor: SharedPreferences.Editor

    lateinit var myPreferences: MyPreference

    @Before
    fun setup() {
        myPreferences = MyPreference(sharedPreferences)
        whenever(sharedPreferences.edit()).thenReturn(sharedPreferencesEditor)
    }

    @Test
    fun savePreferences_VerifyInOrder() {
        myPreferences.saveUserPreferences(1, 1)

        inOrder(sharedPreferencesEditor) {
            verify(sharedPreferencesEditor).putInt(KEY_THEME, 1)
            verify(sharedPreferencesEditor).putInt(KEY_DARK_MODE, 1)
            verify(sharedPreferencesEditor).commit()
        }
    }

    @Test
    fun getSavedTheme() {
        // When: action
        whenever(sharedPreferences.getInt(KEY_THEME,0)).thenReturn(1)

        val theme = myPreferences.getSavedTheme()

        // This is result
        verify(sharedPreferences).getInt(KEY_THEME, 0)
        Assert.assertEquals(1, theme)
    }

    @Test
    fun myPreferences_getDarkMode_State() {
        // When: action
        whenever(sharedPreferences.getInt(KEY_DARK_MODE, 0)).thenReturn(1)

        val darkMode = myPreferences.getDarkModeState()

        verify(sharedPreferences).getInt(KEY_DARK_MODE, 0)
        Assert.assertEquals(1, darkMode)

    }
}