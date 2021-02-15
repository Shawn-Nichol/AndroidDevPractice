package com.example.androiddevpractice

import com.example.androiddevpractice.ui.main.MainActivity
import com.example.androiddevpractice.ui.main.MainActivityViewModel
import org.junit.Test

class MainActivityViewModelTest {




    @Test
    fun myTest() {
        val main: MainActivity = MainActivity()
        val viewModel = MainActivityViewModel(main.application)


    }
}