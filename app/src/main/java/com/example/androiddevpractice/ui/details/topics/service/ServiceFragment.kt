package com.example.androiddevpractice.ui.details.topics.service

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
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

    // Bound Service
    private lateinit var mService: MyBoundService
    private var mBound = false

    private val connection = object : ServiceConnection {
        override fun onServiceDisconnected(name: ComponentName?) {
            mBound = false
        }

        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            // We've bound to localService, cast the IBinder and get LocalService instance
            val binder = service as MyBoundService.LocalBinder
            mService = binder.getService()
            mBound = true
        }
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
        boundService()


        return binding.root
    }

    /**
     * unbinds services should to avoid memory leaks.
     */
    override fun onStop() {
        super.onStop()
        requireContext().unbindService(connection)
        mBound = false
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

    fun boundService() {
        // Bind to LocalService
        Intent(requireContext(), MyBoundService::class.java).also {
            requireContext().bindService(it, connection, Context.BIND_AUTO_CREATE)
        }
    }

    /**
     * Returns random number from service.
     */
    fun randomNumber() {
        Log.i(TAG, "boundService")
        val num = mService.randomNumber
        Toast.makeText(requireContext(), "Number: $num", Toast.LENGTH_SHORT).show()
    }

}