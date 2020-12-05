package com.example.androiddevpractice.topics.userinterface.preferences

import android.os.Bundle
import android.util.Log
import androidx.preference.PreferenceFragmentCompat
import com.example.androiddevpractice.R

class MultiSelectListPreferences : PreferenceFragmentCompat() {

    private val TAG = "PracticeMultiSelectListPreferences"

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.preferences_multi_list, rootKey)
        Log.i(TAG, "onCreatePreferences")


    }



}