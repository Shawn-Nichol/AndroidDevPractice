package com.example.androiddevpractice.topics.userinterface.picker

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.NumberPicker
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.androiddevpractice.R
import com.example.androiddevpractice.databinding.FragmentPickerBinding


class PickerFragment : Fragment() {

    private val TAG = "PracticePickerFragment"
    private lateinit var binding: FragmentPickerBinding
    private lateinit var viewModel: PickerViewModel

    private lateinit var dateTheme: NumberPicker
    private lateinit var timeTheme: NumberPicker

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(PickerViewModel::class.java)

        Log.i(TAG, "onCreate(), Hour = ${viewModel._hour}")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_picker, container, false)
        binding.binding = this
        // Set the ViewModel for DataBinding, this allows the bound layout access to all the data in the ViewModel.
        binding.viewModel = viewModel
        // Specify the fragment view as the lifecycle owner of the binding. This is used so that the
        // binding can observe LiveData updates
        binding.lifecycleOwner = viewLifecycleOwner

        initDateNumberPicker()
        initTimeNumberPicker()
        return binding.root
    }



    fun timePickerButton() {
        Log.i(TAG, "timePickerButton()")
        TimePickerFragment(timeTheme.value).show(activity?.supportFragmentManager!!, "timePicker")
    }

    fun datePickerButton() {
        Log.i(TAG, "datePicker, ${dateTheme.value}")
        DatePickerFragment(dateTheme.value).show(activity?.supportFragmentManager!!, "datePicker")

    }


    private fun initDateNumberPicker() {
        dateTheme = binding.numberPicker
        dateTheme.apply {
            minValue = 1
            maxValue = 5
        }
    }

    private fun initTimeNumberPicker() {
        timeTheme = binding.numberPickerTime
        timeTheme.apply {
            minValue = 1
            maxValue = 5
        }
    }


}