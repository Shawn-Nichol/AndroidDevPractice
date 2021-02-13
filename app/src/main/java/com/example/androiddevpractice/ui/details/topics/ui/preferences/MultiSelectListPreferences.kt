package com.example.androiddevpractice.ui.details.topics.ui.preferences

import android.os.Bundle
import android.util.Log
import androidx.preference.MultiSelectListPreference
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import com.example.androiddevpractice.R

class MultiSelectListPreferences : PreferenceFragmentCompat() {

    private val TAG = "PracticeMultiSelectListPreferences"

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.preferences_multi_list, rootKey)
        Log.i(TAG, "onCreatePreferences")

        val multiList: MultiSelectListPreference? = findPreference("MultiList")
        multiList?.summaryProvider =
            Preference.SummaryProvider<MultiSelectListPreference> { preference ->
                var text: String = ""
                Log.i(TAG, preference.values.toString())
                Log.i(TAG, "Size ${preference.values.size}")
                for (i in 0 until preference.values.size) {
                    Log.i(TAG, preference.values.elementAt(i))

                    text +=  preference.values.elementAt(i)
                    if(i != preference.values.size -1) text += ", "
                }

                "Items selected: $text"
            }
    }


}