package com.example.androiddevpractice.ui.details.topics.worker

import android.content.Context
import android.util.Log
import androidx.work.Data
import androidx.work.Worker
import androidx.work.WorkerParameters
import androidx.work.workDataOf

class MyWorker(context: Context, params: WorkerParameters) : Worker(context, params) {

    private val TAG = "PracMyWorker"
    private var counterOn = true

    companion object {
        const val Progress = "Progress"

    }

    override fun doWork(): Result {
        Log.i(TAG, "doWork()")

        val myData = inputData.getString("KEY_INPUT") ?: return Result.failure()
        Log.i(TAG, "doWork(), $myData")
        counterOn = true

        log()
        Log.i(TAG, "doWork(), work completed")

        val data: Data = Data.Builder()
            .putString("KEY_OUTPUT", "Worker Output")
            .build()
        return Result.success(data)
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
            val update = workDataOf(Progress to counter)
            setProgressAsync(update)

            if(counter == 10) return
        }
    }
}