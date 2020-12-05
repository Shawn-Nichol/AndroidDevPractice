package com.example.androiddevpractice.topics.userinterface.preferences

import android.os.Bundle
import android.util.Log
import androidx.preference.ListPreference
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import com.example.androiddevpractice.R

class ListPreferences : PreferenceFragmentCompat() {

    private val TAG = "PracticeListPreferences"

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.preferences_list, rootKey)
        Log.i(TAG, "onCreatePreferences")


        val listOne: ListPreference? = findPreference("List")
        listOne?.summaryProvider = Preference.SummaryProvider<ListPreference>{ preference ->
            val text = preference.value.toString()

            "List one, $text selected"
        }

        val listTwo: ListPreference? = findPreference("ListTwo")
        listTwo?.summaryProvider = Preference.SummaryProvider<ListPreference> { preference ->
            val text = preference.value.toString()
            "List two, $text selected"
        }

    }



}