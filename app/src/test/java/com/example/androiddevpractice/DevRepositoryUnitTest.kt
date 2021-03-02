package com.example.androiddevpractice

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.androiddevpractice.room.Dev
import com.example.androiddevpractice.room.DevDao
import com.example.androiddevpractice.room.DevRepository
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DevRepositoryUnitTest {

    @get:Rule
    val taskExecutorRule = InstantTaskExecutorRule()

    lateinit var devDao: DevDao
    lateinit var repository: DevRepository

    lateinit var listDevTopicObserver: Observer<List<Dev>>

    @Before
    fun setup() {
//        val dev = Dev("string", "Category", "Detials", 0)
//
//        devDao = mock()
//    //    whenever(devDao.getAllDevTopics("%")).thenReturn(dev)
//        repository = DevRepository(devDao, "%")
//
//        listDevTopicObserver = mock()
//
//
//        repository.listDevTopics.observeForever(listDevTopicObserver)

    }

    @Test
    fun selectTopic() {
//        doReturn(any()).whenever(repository).selectTopic("Test Topic", "TestString")
//        repository.selectTopic("Test Topic", "TestString")
//
//        verify(listDevTopicObserver).onChanged(any())


    }

}