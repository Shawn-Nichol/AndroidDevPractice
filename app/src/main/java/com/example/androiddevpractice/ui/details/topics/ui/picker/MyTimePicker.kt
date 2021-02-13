package com.example.androiddevpractice.ui.details.topics.ui.picker


import android.app.AlertDialog
import android.app.Dialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.text.format.DateFormat
import android.widget.TimePicker
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import java.util.*

class MyTimePicker(timeTheme: Int) : DialogFragment(), TimePickerDialog.OnTimeSetListener {
    val TAG = "PracticeTimePickerFragment"

    val timeTheme = timeTheme

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val c = Calendar.getInstance()
        val hour = c.get(Calendar.HOUR_OF_DAY)
        val minute = c.get(Calendar.MINUTE)

        return when(timeTheme) {
            1 -> TimePickerDialog(activity, AlertDialog.THEME_TRADITIONAL,this, hour, minute, DateFormat.is24HourFormat(activity))
            2 -> TimePickerDialog(activity, AlertDialog.THEME_DEVICE_DEFAULT_DARK, this, hour, minute, DateFormat.is24HourFormat(activity))
            3 -> TimePickerDialog(activity, AlertDialog.THEME_HOLO_LIGHT, this, hour, minute, DateFormat.is24HourFormat(activity))
            4 -> TimePickerDialog(activity, AlertDialog.THEME_HOLO_DARK, this, hour, minute, DateFormat.is24HourFormat(activity))
            else -> TimePickerDialog(activity, AlertDialog.THEME_HOLO_LIGHT, this, hour, minute, DateFormat.is24HourFormat(activity))
        }
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
