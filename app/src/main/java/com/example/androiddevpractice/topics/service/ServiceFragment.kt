package com.example.androiddevpractice.topics.service

import android.app.Notification
import android.app.PendingIntent
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.androiddevpractice.MainActivity
import com.example.androiddevpractice.R
import com.example.androiddevpractice.databinding.FragmentServiceBinding
import com.example.androiddevpractice.topics.userinterface.notification.CHANNEL_ID
import kotlinx.coroutines.channels.ticker


class ServiceFragment : Fragment() {

    val TAG = "PracticeServiceFragment"
    lateinit var binding: FragmentServiceBinding

    lateinit var myService: Intent

    /**
     * The system invokes this method to preform one-time setup procedures when the service is initially
     * created. If the service is already running on onStartCommand or onBind is called.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_service, container, false)

        binding.binding = this

        return binding.root
    }

    fun startMyService() {
        Log.i(TAG, "startMyService")
        myService = Intent(requireContext(), MyService::class.java).also { intent ->
            requireContext().startService(intent)
        }

    }

    /**
     * This button will cause the app to crash after unless the service is put on a different thread.
     */
    fun stopMyService() {
        Log.i(TAG, "stopMyService")
        requireActivity().stopService(myService)

    }

    /**
     * Foreground services must show a status bar notification that has a PRIORITY_LOW or higher. Foreground
     * services should only be used to perform a task that is noticable by the user.
     */
    fun myStartForegroundService() {
        val pendingIntent: PendingIntent =
            Intent(this, MainActivity::class.java).let { notificationIntent ->
                PendingIntent.getActivity(requireActivity(), 0, notificationIntent, 0)
            }

        val notification: Notification = Notification.Builder(requireActivity(), CHANNEL_ID).apply {
            setContentTitle = "Title"
            setSmallIcon(R.drawable.ic_android)
            setContentIntent(pendingIntent)
            ticker("Ticker Text")
            build()
        }

        requireActivity().startForegroundService(2, notification)

    }
}