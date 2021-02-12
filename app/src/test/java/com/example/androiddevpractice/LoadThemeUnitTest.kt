package com.example.androiddevpractice

import com.example.androiddevpractice.ui.main.AppTheme
import org.junit.Assert
import org.junit.Test

class LoadThemeUnitTest {


    @Test
    fun setAppTheme_LoadDefaultThemeIf_ThemeState_equals_zero() {
        val loadTheme = AppTheme()

        val userSelectedTheme = loadTheme.setAppTheme(0)

        Assert.assertEquals(R.style.AppTheme, userSelectedTheme)
    }

    @Test
    fun setAppTheme_LoadDefaultThemeIf_ThemeState_doesntEqual_one() {
        val loadTheme = AppTheme()

        val userSelectedTheme = loadTheme.setAppTheme(2)
        Assert.assertEquals(R.style.AppTheme, userSelectedTheme)
    }

    @Test
    fun setAppTheme_LoadTheme2_ifThemeState_equals_one() {
        val loadTheme = AppTheme()

        val userSelectedTheme = loadTheme.setAppTheme(1)

        Assert.assertEquals(R.style.AppTheme2, userSelectedTheme)
    }


}