package com.example.androiddevpractice.topics.worker

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.work.*
import com.example.androiddevpractice.R
import com.example.androiddevpractice.databinding.FragmentWorkerBinding
import java.util.concurrent.TimeUnit


class WorkerFragment : Fragment(), AdapterView.OnItemClickListener {

    private val TAG = "PracWorkFragment"

    private lateinit var binding: FragmentWorkerBinding

    var counter = 0


    var networkSelection = 0

    lateinit var workManager: WorkManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        workManager = WorkManager.getInstance(requireContext())

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_worker, container, false)

        binding.binding = this
        loadSpinner()

        observerWork()

        return binding.root
    }


    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        networkSelection = 0
    }

    private fun loadSpinner() {
        val spinner = binding.spinnerNetwork
        ArrayAdapter.createFromResource(
            requireActivity(),
            R.array.worker_network_options,
            android.R.layout.simple_spinner_dropdown_item
        ) .also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }
    }

    private fun myWorkRequest(): OneTimeWorkRequest {

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
        val workRequest = OneTimeWorkRequestBuilder<MyWorker>()
            .addTag("One Time Worker")
            .setConstraints(constraints.build())
            .setBackoffCriteria(
                BackoffPolicy.LINEAR,
                OneTimeWorkRequest.MIN_BACKOFF_MILLIS,
                TimeUnit.SECONDS
            )
            .setInputData(myData)
            .build()

        return workRequest
    }

    fun oneTime() {
        Log.i(TAG, "oneTime()")

        val workRequest: OneTimeWorkRequest = myWorkRequest()

        // Submit Work Request to the system
        workManager
            .enqueueUniqueWork(
                "MyWorkRequest",
                ExistingWorkPolicy.KEEP,
                workRequest
            )
    }

    fun cancelWork() {
        workManager
            .cancelUniqueWork("MyWorkRequest")
    }

    private fun observerWork() {
        workManager.getWorkInfosByTagLiveData("One Time Worker")
            .observe(viewLifecycleOwner, Observer<List<WorkInfo>> { listOfWorkInfo ->
                Log.i(TAG, "Start observing")
                if (listOfWorkInfo.isNullOrEmpty()) {
                    Log.i(TAG, "listOfWorkInfo is empty")
                    return@Observer
                }

                val workInfo = listOfWorkInfo[0]
                when (workInfo.state) {
                    WorkInfo.State.RUNNING -> {
                        Log.i(TAG, "Worker is running")
                        Toast.makeText(context, "Worker is Running", Toast.LENGTH_SHORT).show()
                    }
                    WorkInfo.State.CANCELLED -> {
                        Log.i(TAG, "Worker canceled")
                        Toast.makeText(context, "Worker is Cancelled", Toast.LENGTH_SHORT).show()
                        return@Observer
                    }
                    WorkInfo.State.SUCCEEDED -> {
                        Log.i(TAG, "Worker Succeeded")
                        Toast.makeText(context, "Worker is Succeeded", Toast.LENGTH_SHORT).show()
                        return@Observer
                    }
                    else -> {
                        Log.i(TAG, "WorkInfo else")
                        Toast.makeText(context, "Worker Nothing", Toast.LENGTH_SHORT).show()
                    }
                }
            })
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