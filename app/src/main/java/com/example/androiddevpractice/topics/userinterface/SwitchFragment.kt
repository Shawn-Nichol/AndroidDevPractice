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
import com.example.androiddevpractice.databinding.FragmentSwitchBinding


class SwitchFragment : Fragment() {

    private val TAG = "PracticeSwitchFragment"

    private val SWITCH_KEY_ONE = "Switch key one"
    private lateinit var binding: FragmentSwitchBinding
    private lateinit var sharedPref: SharedPreferences

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
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_switch, container, false)
        binding.binding = this

        binding.switchOne.isChecked = sharedPref.getBoolean(SWITCH_KEY_ONE, false)


        return binding.root
    }

    /**
     * Saves the state of the switch
     */
    override fun onPause() {
        super.onPause()
        with(sharedPref.edit()) {
            putBoolean(SWITCH_KEY_ONE, binding.switchOne.isChecked)
            // apply will save to sharePref and then update the sharedPref file Asynchronously on a
            // different thread
            apply()
        }
    }

    fun switchClick() {
        binding.switchOne.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked) {
                // Switch is on
            } else {
                // Switch is off
            }
            Log.i(TAG, "switchClick(), switch state = ${binding.switchOne.isChecked}")
        }
    }
}