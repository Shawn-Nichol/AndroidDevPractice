package com.example.androiddevpractice.ui.details.topics.ui.preferences

import android.os.Bundle
import android.util.Log
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import androidx.preference.SeekBarPreference
import com.example.androiddevpractice.R

class SeekBarPreferences : PreferenceFragmentCompat() {

    private val TAG = "PracticeSeekBarPreferences"

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.preferences_seek_bar, rootKey)
        Log.i(TAG, "onCreatePreferences")

        val seekBar: SeekBarPreference? = findPreference("SeekBar")
        seekBar?.summaryProvider = Preference.SummaryProvider<SeekBarPreference> {preference ->
            var text = preference.value.toString()

            "SeekBar set to : $text"
        }


    }



}