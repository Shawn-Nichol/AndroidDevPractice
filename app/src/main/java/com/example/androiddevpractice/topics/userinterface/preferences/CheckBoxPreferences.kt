package com.example.androiddevpractice.topics.userinterface.preferences

import android.os.Bundle
import android.util.Log
import androidx.preference.PreferenceFragmentCompat
import com.example.androiddevpractice.R

class CheckBoxPreferences : PreferenceFragmentCompat() {

    private val TAG = "PracticeCheckBoxPreference"

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.preferences_check_box, rootKey)
        Log.i(TAG, "onCreatePreferences")


    }



}