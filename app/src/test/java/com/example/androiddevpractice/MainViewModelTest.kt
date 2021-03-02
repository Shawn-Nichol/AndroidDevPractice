package com.example.androiddevpractice

import android.app.Application
import android.content.Context
import androidx.lifecycle.Observer
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.androiddevpractice.room.Dev
import com.example.androiddevpractice.ui.main.MainActivityViewModel
import com.nhaarman.mockitokotlin2.mock
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.stubbing.OngoingStubbing
import org.robolectric.annotation.Config

@Config(manifest= Config.NONE)
@RunWith(AndroidJUnit4::class)
class MainViewModelTest {

    lateinit var viewModel: MainActivityViewModel

    val context = ApplicationProvider.getApplicationContext<Context>()

    private lateinit var listOfDevTopicsObserver: Observer<List<Dev>>

    @Before
    fun setup() {
        // TODO Still working setting up context.
        viewModel = MainActivityViewModel(context as Application)

        listOfDevTopicsObserver = mock()

        viewModel.listOfDevTopics.observeForever(listOfDevTopicsObserver)

    }

    @Test
    fun searchTopic() {

        // can't use this because the viewModel repository is not mocked.
        //whenever(viewModel.repository.listDevTopics).thenReturn(any())

        // When
        viewModel.searchTopic("UI")

        // Then results





    }
}

private fun <T> OngoingStubbing<T>.thenReturn(testlist: MutableList<Dev>) {
    TODO("Not yet implemented")
}
