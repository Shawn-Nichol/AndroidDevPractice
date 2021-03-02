package com.example.androiddevpractice

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.platform.app.InstrumentationRegistry
import com.example.androiddevpractice.room.DevDao
import com.example.androiddevpractice.room.DevDatabase
import com.example.androiddevpractice.ui.main.MainActivityViewModel
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito



class MainActivityViewModelTest {

    @get:Rule
    val taskExecutorRule = InstantTaskExecutorRule()

    private val devDao: DevDao = Mockito.spy(
        Room.inMemoryDatabaseBuilder(
            InstrumentationRegistry.getInstrumentation().context,
            DevDatabase::class.java).build().devDao()
        )


    private val viewModel = MainActivityViewModel(ApplicationProvider.getApplicationContext())
    @Test
    fun myTest() {



    }
}