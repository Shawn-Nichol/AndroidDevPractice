package com.example.androiddevpractice

import com.example.androiddevpractice.ui.details.topics.worker.WorkerCounter
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class WorkerCounterUnitTest {

    lateinit var counter: WorkerCounter


    @Before
    fun setup() {
        counter = WorkerCounter()
    }

    @Test()
    fun countUp_IncreaseCount() {
        counter.countUp()
        Assert.assertEquals(1, counter.count)
    }

    @Test
    fun countUp_calledThreeTimes() {
        counter.countUp()
        counter.countUp()
        counter.countUp()

        Assert.assertEquals(3, counter.count)
    }

    @Test
    fun countUp_returnString() {
        val counter = counter.countUp()
        Assert.assertEquals("1", counter)
    }

    @Test
    fun countDown() {
        counter.countDown()
        Assert.assertEquals(-1, counter.count)
    }

    @Test
    fun countDown_calledThreeTimes() {
        counter.countDown()
        counter.countDown()
        counter.countDown()
        Assert.assertEquals(-3, counter.count)
    }

    @Test
    fun countDown_returnString() {
        val counter = counter.countDown()
        Assert.assertEquals("-1", counter)

    }
}