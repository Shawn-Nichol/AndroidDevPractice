package com.example.androiddevpractice.ui.details.topics.worker

class WorkerCounter {

    var count = 0

    fun countUp(): String {
        count++
        return count.toString()
    }

    fun countDown(): String {
        count--
        return count.toString()
    }


}