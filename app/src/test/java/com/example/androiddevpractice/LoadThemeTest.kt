package com.example.androiddevpractice

import com.example.androiddevpractice.ui.LoadTheme
import org.junit.Assert
import org.junit.Test

class LoadThemeTest {



    @Test
    fun setAppTheme_LoadDefaultThemeIf_ThemeState_equals_zero() {
        val loadTheme = LoadTheme()

        val userSelectedTheme = loadTheme.setAppTheme(0)

        Assert.assertEquals(R.style.AppTheme, userSelectedTheme)
    }

    @Test
    fun setAppTheme_LoadDefaultThemeIf_ThemeState_doesntEqual_one() {
        val loadTheme = LoadTheme()

        val userSelectedTheme = loadTheme.setAppTheme(2)
        Assert.assertEquals(R.style.AppTheme, userSelectedTheme)
    }

    @Test
    fun setAppTheme_LoadTheme2_ifThemeState_equals_one() {
        val loadTheme = LoadTheme()

        val userSelectedTheme = loadTheme.setAppTheme(1)
    }


}