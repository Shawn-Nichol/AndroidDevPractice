package com.example.androiddevpractice.topics.service

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.androiddevpractice.R
import com.example.androiddevpractice.databinding.FragmentServiceBinding
import com.example.androiddevpractice.topics.userinterface.notification.MyNotificationChannel


class ServiceFragment : Fragment() {

    val TAG = "PracticeServiceFragment"
    lateinit var binding: FragmentServiceBinding

    lateinit var myService: Intent
    lateinit var foregroundIntent: Intent

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

        myForegroundService()
        myService()

        return binding.root
    }

    /**
     *
     */
    fun myService() {
        myService = Intent(requireContext(), MyService::class.java)

        binding.btnStartService.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked) {
                requireContext().startService(myService)
            } else {
                requireContext().stopService(myService)
            }
        }
    }

    /**
     * Foreground services must show a status bar notification that has a PRIORITY_LOW or higher. Foreground
     * services should only be used to perform a task that is noticable by the user.
     */
    fun myForegroundService() {

        // Start Notification channel.
        MyNotificationChannel(requireContext())

        // Intent for service.
        foregroundIntent = Intent(requireContext(), MyForegroundService::class.java)

        binding.btnStartForeground.setOnCheckedChangeListener{_, isChecked ->
            Log.i(TAG, "Btn state $isChecked")
            if(isChecked) {
                Log.i(TAG, "StartForegroundService")
                requireContext().startForegroundService(foregroundIntent)

            } else {
                Log.i(TAG, "StopForegroundService")
                requireContext().stopService(foregroundIntent)
            }

        }

    }


}