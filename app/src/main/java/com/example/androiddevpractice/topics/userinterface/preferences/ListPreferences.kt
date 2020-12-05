package com.example.androiddevpractice.topics.userinterface.preferences

import android.os.Bundle
import android.util.Log
import androidx.preference.PreferenceFragmentCompat
import com.example.androiddevpractice.R

class ListPreferences : PreferenceFragmentCompat() {

    private val TAG = "PracticeListPreferences"

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.preferences_list, rootKey)
        Log.i(TAG, "onCreatePreferences")


    }



}