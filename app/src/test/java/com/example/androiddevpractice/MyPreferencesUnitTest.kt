package com.example.androiddevpractice

import android.content.SharedPreferences
import com.example.androiddevpractice.ui.main.KEY_DARK_MODE
import com.example.androiddevpractice.ui.main.KEY_THEME

import com.example.androiddevpractice.ui.main.MyPreference
import com.nhaarman.mockitokotlin2.inOrder
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import org.junit.Before
import org.junit.Test

class MyPreferencesUnitTest {

    lateinit var sharedPreferences: SharedPreferences
    lateinit var sharedPreferencesEditor: SharedPreferences.Editor
    lateinit var myPreferences: MyPreference

    @Before
    fun setup() {
        sharedPreferences = mock()
        sharedPreferencesEditor = mock()
        myPreferences = MyPreference(sharedPreferences)
    }

    @Test
    fun myPreferences_SavePreferences() {

        whenever(sharedPreferences.edit()).thenReturn(sharedPreferencesEditor)

        myPreferences.saveUserPreferences(1, 1)


        inOrder(sharedPreferencesEditor) {
            verify(sharedPreferencesEditor).putInt(KEY_THEME, 1)
            verify(sharedPreferencesEditor).putInt(KEY_DARK_MODE, 1)
            verify(sharedPreferencesEditor).commit()
        }
    }

    @Test
    fun myPreferences_CallsGetSharedPreference() {
        myPreferences.getSavedTheme()
        verify(sharedPreferences).getInt(KEY_THEME, 0)
    }

    @Test
    fun myPreferences_getDarkMode_State() {
        myPreferences.getDarkModeState()
        verify(sharedPreferences).getInt(KEY_DARK_MODE, 0)
    }

// Todo find a way to save the data and load the saved data in a unit test.
//    @Test
//    fun myPreferences_theme_GetSharedPreference_Data() {
//        whenever(sharedPreferences.edit()).thenReturn(sharedPreferencesEditor)
//        myPreferences.saveUserPreferences(1, 1)
//
//        val themeNumber = myPreferences.getSavedTheme()
//
//        Assert.assertEquals(1, themeNumber)
//    }


}