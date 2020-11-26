package com.example.androiddevpractice.topics.userinterface.picker

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.Dialog
import android.icu.util.Calendar
import android.os.Bundle
import android.util.Log

import android.widget.DatePicker
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider

class MyDatePicker(dateTheme: Int) : DialogFragment(), DatePickerDialog.OnDateSetListener {

    var dateTheme: Int = dateTheme

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
    // Use the current date as the default date in the picker
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        Log.i("PracticeDatePicker", "Theme = $dateTheme")
        // Create a new instance of DatePickerDialog and return it
        return when(dateTheme) {
            1 -> DatePickerDialog(requireContext(), AlertDialog.THEME_TRADITIONAL,this, year, month, day)
            2 -> DatePickerDialog(requireContext(), AlertDialog.THEME_DEVICE_DEFAULT_DARK,this, year, month, day)
            3 -> DatePickerDialog(requireContext(), AlertDialog.THEME_DEVICE_DEFAULT_LIGHT,this, year, month, day)
            4 -> DatePickerDialog(requireContext(), AlertDialog.THEME_HOLO_DARK,this, year, month, day)
            else -> DatePickerDialog(requireContext(), AlertDialog.THEME_HOLO_LIGHT,this, year, month, day)
        }

    }

    override fun onDateSet(view: DatePicker, year: Int, month: Int, day: Int) {
        val viewModel = ViewModelProvider(requireActivity()).get(PickerViewModel::class.java)
        viewModel._day.postValue(day)
        viewModel._month.postValue(month)
        viewModel._year.postValue(year)
    }
}