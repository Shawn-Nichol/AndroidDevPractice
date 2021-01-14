package com.example.androiddevpractice.topics.worker

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.work.*
import com.example.androiddevpractice.R
import com.example.androiddevpractice.databinding.FragmentWorkerBinding
import java.util.concurrent.TimeUnit


class WorkerFragment : Fragment() {

    private val TAG = "PracWorkFragment"

    private lateinit var binding: FragmentWorkerBinding

    var counter = 0

    lateinit var workRequest: OneTimeWorkRequest



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_worker,container, false)

        binding.binding  = this
        myWorkRequest()

        return binding.root
    }


    fun myWorkRequest() {

        val myData = Data.Builder()
            .putString("KEY_INPUT", "This is myData")
            .build()

        val constraints = Constraints.Builder().apply {
           setRequiredNetworkType(NetworkType.NOT_REQUIRED)
            setRequiresBatteryNotLow(binding.swBatteryNotLow.)
            setRequiresCharging()
            setRequiresDeviceIdle(true)
            setRequiresStorageNotLow(true)

        }

        // Create Work Request.
        workRequest = OneTimeWorkRequestBuilder<MyWorker>()
            .addTag("One Time Worker")
            .setConstraints(constraints.build())
            .setBackoffCriteria(
                BackoffPolicy.LINEAR,
                OneTimeWorkRequest.MIN_BACKOFF_MILLIS,
                TimeUnit.SECONDS
            )
            .setInputData(myData)
            .build()
    }


    fun oneTime() {
        Log.i(TAG, "oneTime()")

        // Submit Work Request to the system
        WorkManager
            .getInstance(requireContext())
            .enqueueUniqueWork("MyWorkRequest",
                ExistingWorkPolicy.KEEP,
                workRequest
            )
    }

    fun cancelWork() {
        WorkManager
            .getInstance(requireContext())
            .cancelUniqueWork("MyWorkRequest")
    }


    fun counterPlus() {
        counter++
        binding.tvCounter.text = counter.toString()
    }

    fun counterMinus() {
        counter--
        binding.tvCounter.text = counter.toString()
    }

}