package com.example.androiddevpractice.topics.userinterface.notification

import android.app.PendingIntent
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.androiddevpractice.MainActivity
import com.example.androiddevpractice.R
import com.example.androiddevpractice.databinding.FragmentNotificationBinding
import com.example.androiddevpractice.topics.userinterface.CHANNEL_ID
import com.example.androiddevpractice.topics.userinterface.MyNotificationChannel

class NotificationFragment : Fragment() {

    private lateinit var binding: FragmentNotificationBinding
    val notificationID  = 55

    lateinit var builder: NotificationCompat.Builder

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_notification, container, false)
        binding.binding = this

        initNotification()
        actionButtonState()
        return binding.root
    }

    fun initNotification() {
        MyNotificationChannel(requireContext())
        // Create an explicit intent for an Activity in your app.
        val myIntent = Intent(requireActivity(), MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(requireActivity(), 0, myIntent, 0)
        builder = NotificationCompat.Builder(requireActivity(), CHANNEL_ID).apply {
            setSmallIcon(R.drawable.ic_head)
            setContentTitle("My Title")
            setContentText("My Notification Text info.")
            setContentIntent(pendingIntent)
            setAutoCancel(true) // Remove the notification after tap
        }
    }

    fun launchNotification() {
        // To make the notification appear,
        with(NotificationManagerCompat.from(requireContext())) {
            notify(notificationID, builder.build())
        }
    }

    /**
     * monitors changes the action button switches
     */
    fun actionButtonState() {
        binding.switch1.setOnCheckedChangeListener {_, isChecked ->
                onActions()
        }

        binding.switch2.setOnCheckedChangeListener { _, isChecked ->
            onActions()
        }

        binding.switch3.setOnCheckedChangeListener { _, isChecked ->
            onActions()
        }
    }

    /**
     * onActions, remomves all the action buttons, then will add all the active buttons to the notification
     */
    fun onActions() {
        val myIntent = Intent(requireActivity(), MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(requireActivity(), 0, myIntent, 0)

        builder.mActions.clear()
        if(binding.switch1.isChecked) builder.addAction(R.drawable.ic_head, "Action One", pendingIntent)
        if(binding.switch2.isChecked) builder.addAction(R.drawable.ic_head, "Action Two", pendingIntent)
        if(binding.switch3.isChecked) builder.addAction(R.drawable.ic_head, "Action Three", pendingIntent)
    }


}