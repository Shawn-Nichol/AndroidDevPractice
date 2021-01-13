package com.example.androiddevpractice.topics.worker

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class MyWorker(context: Context, params: WorkerParameters) : Worker(context, params) {

    private val TAG = "PracMyWorker"

    override fun doWork(): Result {
        Log.i(TAG, "doWork()")

        val myData = inputData.getString("KEY_INPUT") ?: return Result.failure()


        Log.i(TAG, "doWork(), $myData")
        for(i in 0..10) {
            Log.i(TAG, "doWork $i")
            Thread.sleep(1000)
        }

        return Result.success()
    }

    override fun onStopped() {
        super.onStopped()
        Log.i(TAG, "onStopped")
    }
}