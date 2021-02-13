package com.example.androiddevpractice.ui.details.topics.service

import android.app.Notification
import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import com.example.androiddevpractice.R
import com.example.androiddevpractice.ui.details.topics.ui.notification.CHANNEL_ID
import com.example.androiddevpractice.ui.main.MainActivity

class MyForegroundService : Service() {
    private var TAG = "PracticeMyForeground"

    /**
     * The system invokes this method to prefrom one-time setup procedures when the service is initially created.
     * If the service is already running, this method is not called.
     */
    override fun onCreate() {
        super.onCreate()
        Log.i(TAG, "onCreate")
        val intent = Intent(this, MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(this, 0, intent, 0)

        val notification = Notification.Builder(this, CHANNEL_ID).apply {
            setContentTitle("Foreground Title")
            setContentText("Foreground Text")
            setSmallIcon(R.drawable.ic_android)
            setContentIntent(pendingIntent)
        }

        startForeground(2, notification.build())

    }

    /**
     * System invokes this method by calling startService() when another component requests that the service be started.
     * When this methd executes the service is started and can run in the background indefinitely. If you implement this
     * it is your responsibility to stop the service when its work is complete by calling stopSelf() or stopService()
     */
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.i(TAG, "onStartCommand")
//        for (i in 0..9) {
//            Log.i(TAG, "onStartCommand: counter $i")
//            SystemClock.sleep(1000)
//        }
        return START_STICKY

    }

    /**
     * The system invokes this mehod by calling bindService() when another component wants to bind with
     * the service. You must provide an interface that clients use to communicate with the service by
     * returning an IBinder. you must always implement this method however if you don't want to allow binding, you should return null.
     */
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }


    /**
     * The system invokes this method when the service is no longer used and is being destroyed.
     * Your service should implement this to clean up any resources that the service receives.
     *
     */
    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "onDestroy")
    }
}