package com.example.androiddevpractice.topics.userinterface.preferences

import android.os.Bundle
import android.util.Log
import androidx.preference.PreferenceFragmentCompat
import com.example.androiddevpractice.R


class MyPreferencesFragment : PreferenceFragmentCompat() {

   private val TAG = "PracticeMyPreferencesFragment"

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.preferences, rootKey)
        Log.i(TAG, "onCreatePreferences")


//        val ui: Preference? = findPreference("UIPreference")
//        ui?.setOnPreferenceClickListener {
//            Log.i(TAG, "Click")
//            true
//        }
    }



}

