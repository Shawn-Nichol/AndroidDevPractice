package com.example.androiddevpractice.topics.userinterface

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.androiddevpractice.R
import com.example.androiddevpractice.databinding.FragmentToggleButtonBinding


class ToggleButtonFragment : Fragment() {

    private val TAG = "PracticeToggleButton"
    private val TOGGLE_KEY = "Toggle Key One"

    private lateinit var binding: FragmentToggleButtonBinding
    private lateinit var sharedPref: SharedPreferences


    // Bound service

    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPref = activity?.getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE)
            ?: return
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_toggle_button, container, false)
        binding.binding = this

        // Loads the saved state of the toggle button
        binding.toggleButton.isChecked = sharedPref.getBoolean(TOGGLE_KEY, false)

        return binding.root
    }

    /**
     * Saves the state of the toggle button.
     */
    override fun onPause() {
        super.onPause()
        with(sharedPref.edit()) {
            putBoolean(TOGGLE_KEY, binding.toggleButton.isChecked)
            apply()
        }
    }

    fun toggleButtonOne() {

        binding.toggleButton.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked) // do something.
            Log.i(TAG, "Toggle button state: ${binding.toggleButton.isChecked}")

        }

    }
}