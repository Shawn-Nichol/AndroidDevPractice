package com.example.androiddevpractice.topics.userinterface.picker


import android.app.Dialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.text.format.DateFormat
import android.util.Log
import android.widget.TimePicker
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider

class TimePickerFragment : DialogFragment(), TimePickerDialog.OnTimeSetListener {
    val TAG = "PracticeTimePickerFragment"

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val c = java.util.Calendar.getInstance()
        val hour = c[java.util.Calendar.HOUR_OF_DAY]
        val minute = c[java.util.Calendar.MINUTE]
        Log.i(TAG, "onCreateView")
        return TimePickerDialog(activity, this, hour, minute, DateFormat.is24HourFormat(activity))
    }

    /**
     * Posts select to the Pickers ViewModel so the data can be used loaded into the layout.
     */
    override fun onTimeSet(view: TimePicker, hourOfDay: Int, minute: Int) {
        val viewModel = ViewModelProvider(requireActivity()).get(PickerViewModel::class.java)
        viewModel._hour.postValue(hourOfDay)
        viewModel._minute.postValue(minute)
    }
}
