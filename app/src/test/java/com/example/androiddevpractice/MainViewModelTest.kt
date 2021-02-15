package com.example.androiddevpractice

import androidx.test.core.app.ApplicationProvider
import com.example.androiddevpractice.ui.main.MainActivityViewModel
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MainViewModelTest {

    lateinit var viewModel: MainActivityViewModel

    @Before
    fun setup() {
        viewModel = MainActivityViewModel(ApplicationProvider.getApplicationContext())

    }

    @Test
    fun myTest() {
        Assert.assertEquals(2, 2)
    }
}