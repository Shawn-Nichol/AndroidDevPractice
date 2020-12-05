package com.example.androiddevpractice.topics.userinterface.preferences

import android.os.Bundle
import android.text.InputType
import android.text.TextUtils
import android.util.Log
import androidx.preference.EditTextPreference
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import com.example.androiddevpractice.R

class EditTextPreferences : PreferenceFragmentCompat() {

    private val TAG = "EditTextPreferences"

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.preferences_edit_text, rootKey)
        Log.i(TAG, "onCreatePreferences")

        // Update summary
        val counting: EditTextPreference? = findPreference("counting")
        counting?.summaryProvider = Preference.SummaryProvider<EditTextPreference> { preference ->
            val text = preference.text
            if(TextUtils.isEmpty(text)) "Not Set"
            else "Length of saved value: ${text.length}"
        }

        // User can only enter a number input
        val number: EditTextPreference? = findPreference("number")
        number?.setOnBindEditTextListener { editText ->
            editText.inputType = InputType.TYPE_CLASS_NUMBER
        }

        // Handle click of preference.
        number?.setOnPreferenceClickListener {
            Log.i(TAG, "number onclick")
            true
        }

    }

}