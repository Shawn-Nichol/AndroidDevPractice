package com.example.androiddevpractice.topics.worker

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView

import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.work.*
import com.example.androiddevpractice.R
import com.example.androiddevpractice.databinding.FragmentWorkerBinding
import java.util.concurrent.TimeUnit


class WorkerFragment : Fragment(), AdapterView.OnItemClickListener {

    private val TAG = "PracWorkFragment"

    private lateinit var binding: FragmentWorkerBinding

    var counter = 0

    lateinit var workRequest: OneTimeWorkRequest
    var networkSelection = 0


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_worker, container, false)

        binding.binding = this
        loadSpinner()
        myWorkRequest()


        return binding.root
    }


    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        networkSelection = 0
        myWorkRequest()
    }

    private fun loadSpinner() {
        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.worker_network_options,
            android.R.layout.simple_spinner_item
        )
            .also { adapter ->
                //Specify the layout
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

                binding.spinnerNetwork.adapter = adapter

            }
    }


    private fun myWorkRequest() {

        val myData = Data.Builder()
            .putString("KEY_INPUT", "This is myData")
            .build()

        val constraints = Constraints.Builder().apply {
            when (networkSelection) {
                1 -> setRequiredNetworkType(NetworkType.NOT_REQUIRED)
                2 -> setRequiredNetworkType(NetworkType.CONNECTED)
                3 -> setRequiredNetworkType(NetworkType.METERED)
                4 -> setRequiredNetworkType(NetworkType.NOT_ROAMING)
                else -> setRequiredNetworkType(NetworkType.UNMETERED)
            }
            setRequiresBatteryNotLow(binding.swBatteryNotLow.isChecked)
            setRequiresCharging(binding.swCharging.isChecked)
            setRequiresDeviceIdle(binding.swIdle.isChecked)
            setRequiresStorageNotLow(binding.swStorageLow.isChecked)

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
            .enqueueUniqueWork(
                "MyWorkRequest",
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