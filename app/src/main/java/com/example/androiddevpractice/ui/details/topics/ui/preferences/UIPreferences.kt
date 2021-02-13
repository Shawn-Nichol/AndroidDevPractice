package com.example.androiddevpractice.ui.details.topics.ui.preferences

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import com.example.androiddevpractice.R

class UIPreferences : PreferenceFragmentCompat() {
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.preferences_ui, rootKey)
    }
}