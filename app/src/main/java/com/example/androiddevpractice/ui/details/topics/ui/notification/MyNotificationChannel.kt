package com.example.androiddevpractice.ui.details.topics.ui.notification


import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build

val CHANNEL_ID = "My Notification ID"

fun MyNotificationChannel(context: Context) {
    // Notification for API 26+.
    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        val name = "My Notification Channel Name"
        val descriptionText = "This is my notification description."
        val importance = NotificationManager.IMPORTANCE_HIGH

        val channel = NotificationChannel(CHANNEL_ID, name, importance).apply {
            description = descriptionText
        }

        val nm : NotificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        nm.createNotificationChannel(channel)
    }
}