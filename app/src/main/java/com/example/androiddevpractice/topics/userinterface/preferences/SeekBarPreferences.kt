package com.example.androiddevpractice.topics.userinterface.preferences

import android.os.Bundle
import android.util.Log
import androidx.preference.PreferenceFragmentCompat
import com.example.androiddevpractice.R

class SeekBarPreferences : PreferenceFragmentCompat() {

    private val TAG = "PracticeSeekBarPreferences"

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.preferences_seek_bar, rootKey)
        Log.i(TAG, "onCreatePreferences")


    }



}