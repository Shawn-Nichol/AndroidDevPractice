package com.example.androiddevpractice

import android.content.Context
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class TextSetupUnitTest {


    @Mock
    private lateinit var mockContext: Context

    val testList =
        listOf("Summary", "Title One: List Item one", "Title Two: ListItemTwo with example *** ServiceFragment")

    //TODO need to be able to test private classes.
    // TODO pass a list
    @Test
    fun summaryString() {




    }
}