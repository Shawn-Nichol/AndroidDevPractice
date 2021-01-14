package com.example.androiddevpractice.topics.worker

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class MyWorker(context: Context, params: WorkerParameters) : Worker(context, params) {

    private val TAG = "PracMyWorker"
    private var counterOn = true

    override fun doWork(): Result {
        Log.i(TAG, "doWork()")

        val myData = inputData.getString("KEY_INPUT") ?: return Result.failure()
        Log.i(TAG, "doWork(), $myData")
        counterOn = true

        log()
        return Result.success()
    }

    override fun onStopped() {
        super.onStopped()
        Log.i(TAG, "onStopped")
        counterOn = false
    }


    fun log() {
        var counter = 0
        while(counterOn){
            counter++
            Log.i(TAG, "Counter, $counter")
            Thread.sleep(1000)
            if(counter == 10) return
        }
    }
}