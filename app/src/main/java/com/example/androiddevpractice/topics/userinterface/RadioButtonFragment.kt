package com.example.androiddevpractice.topics.userinterface

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.androiddevpractice.R
import com.example.androiddevpractice.databinding.FragmentRadioButtonBinding


class RadioButtonFragment : Fragment() {

    private val TAG = "PracticeRadioButtonFragment"

    private lateinit var binding: FragmentRadioButtonBinding
    private lateinit var sharedPref: SharedPreferences

    private val RADIO_KEY = "RadioButtonFragment"
    private var selectedButton: Int = 0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPref = activity?.getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE)
            ?: return


        selectedButton = sharedPref.getInt(RADIO_KEY, 0)
        Log.i(TAG, "onCreate(), selected Button = $selectedButton")


    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_radio_button, container, false)
        binding.binding = this


        when(selectedButton) {
            1 -> binding.radioBtnOne.isChecked = true
            2 -> binding.radioBtnTwo.isChecked = true
            3 -> binding.radioBtnThree.isChecked = true
        }


        return binding.root
    }

    /**
     * Saves the currently selected Radio Button, so it can be reloaded when the Fragment is recreated.
     */
    override fun onPause() {
        super.onPause()
        Log.i(TAG, "onPause(), selectedButton = $selectedButton")
        with(sharedPref.edit()) {
            // Save current key
            putInt(RADIO_KEY, selectedButton)
            // Apply changes the in-memory SharedPreference object immediately but writes the
            // updates to the disk Asynchronously.
            // Commit will writes synchronously and could pause the UI thread.
            apply()
        }
    }

    fun radioOnClick(view: View) {
        if(view is RadioButton) {
            // Is the button checked.
            val checked = view.isChecked

            // Check which radio button
            when(view.id) {
                R.id.radio_btn_one ->
                    if (checked) {
                        selectedButton = 1
                        Toast.makeText(context, "Radio Button one", Toast.LENGTH_SHORT).show()
                    }
                R.id.radio_btn_two ->
                    if (checked) {
                        selectedButton = 2
                        Toast.makeText(context, "Radio Button two", Toast.LENGTH_SHORT).show()
                    }
                R.id.radio_btn_three ->
                    if(checked) {
                        selectedButton = 3
                        Toast.makeText(context, "Radio Button Three", Toast.LENGTH_SHORT).show()
                    }
            }
        }
    }
}