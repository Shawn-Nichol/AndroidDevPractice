package com.example.androiddevpractice.topics.userinterface.notification

import android.annotation.SuppressLint
import android.app.PendingIntent
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.RadioButton
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.androiddevpractice.MainActivity
import com.example.androiddevpractice.R
import com.example.androiddevpractice.databinding.FragmentNotificationBinding
import com.example.androiddevpractice.topics.userinterface.CHANNEL_ID
import com.example.androiddevpractice.topics.userinterface.MyNotificationChannel

class NotificationFragment : Fragment(), AdapterView.OnItemSelectedListener {

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

        initPrioritySpinner()
        initNotification()
        actionButtonState()
        return binding.root
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, pos: Int, id: Long) {
        when(parent?.getItemAtPosition(pos)) {
            0 -> builder.priority = NotificationCompat.PRIORITY_DEFAULT
            1 -> builder.priority = NotificationCompat.PRIORITY_HIGH
            2 -> builder.priority = NotificationCompat.PRIORITY_LOW
            3 -> builder.priority = NotificationCompat.PRIORITY_MAX
            4 -> builder.priority = NotificationCompat.PRIORITY_MIN

        }
    }

    override fun onNothingSelected(view: AdapterView<*>?) {

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
    @SuppressLint("RestrictedApi")
    fun onActions() {
        val myIntent = Intent(requireActivity(), MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(requireActivity(), 0, myIntent, 0)

        builder.mActions.clear()
        if(binding.switch1.isChecked) builder.addAction(R.drawable.ic_head, "Action One", pendingIntent)
        if(binding.switch2.isChecked) builder.addAction(R.drawable.ic_head, "Action Two", pendingIntent)
        if(binding.switch3.isChecked) builder.addAction(R.drawable.ic_head, "Action Three", pendingIntent)
    }

    fun setCategory(view: View) {
        if(view is RadioButton) {
            val checked = view.isChecked
            // Check which radio button was clicked
            when(view.getId()) {
                R.id.radioButton_category_alarm ->
                    builder.setCategory(NotificationCompat.CATEGORY_ALARM)
                R.id.radioButton_category_call ->
                    builder.setCategory(NotificationCompat.CATEGORY_CALL)
                R.id.radioButton_category_event ->
                    builder.setCategory(NotificationCompat.CATEGORY_EVENT)
                R.id.radioButton_category_reminder ->
                    builder.setCategory(NotificationCompat.CATEGORY_REMINDER)
            }
        }
    }

    fun initPrioritySpinner() {
        val spinner = binding.spinnerNotificationSetPriority
        // Create an ArrayAdapter using the string array and a default spinner layout.
        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.notification_priority,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner.adapter = adapter
        }
    }


}