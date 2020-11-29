package com.example.androiddevpractice.topics.userinterface

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.androiddevpractice.R
import com.example.androiddevpractice.databinding.FragmentSystemUiBinding


class SystemUIFragment : Fragment() {

    private lateinit var binding: FragmentSystemUiBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_system_ui, container, false)
        binding.binding = this



        return binding.root
    }


    fun radioButton(view: View) {
        if (view is RadioButton) {
            val checked = view.isChecked

            when (view.id) {
                R.id.radio_dim_status -> dimStatusBar()
                R.id.radio_hide_status -> hideMyStatusBar()
                R.id.radio_navigation -> hideNavigationBar()
                R.id.radio_lean_back -> leanBack()
                R.id.radio_immersive -> immersive()
                R.id.radio_immersive_sticky -> immersiveSticky()
                else -> {
                    requireActivity().window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE)
                }

            }
        }
    }

    private fun dimStatusBar() {
        activity?.window?.decorView?.apply {
            systemUiVisibility = View.SYSTEM_UI_FLAG_LOW_PROFILE
        }
    }

    private fun hideMyStatusBar() {
        // Note:
        // where you set the Hide makes a difference
        // Navigating away causes the flags to be reset.
        requireActivity().window.decorView.systemUiVisibility =
            View.SYSTEM_UI_FLAG_FULLSCREEN
        // You should hide the action bar if the status bar is hidden
    }

    private fun hideNavigationBar() {
        requireActivity().window.decorView.systemUiVisibility =
            View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
    }

    /**
     * Sets the app to full screen, system bars will appear when the user taps on the screen.
     */
    private fun leanBack() {
        requireActivity().window.decorView.systemUiVisibility =
            (View.SYSTEM_UI_FLAG_FULLSCREEN or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION)
    }

    /**
     * Sets the app to full screen, system bars will appear when the user swipes down from the top.
     */
    private fun immersive() {
        requireActivity().window.decorView.systemUiVisibility =
            (View.SYSTEM_UI_FLAG_IMMERSIVE
                    // Set the content to appear under the system bar so that the content doesn't
                    // resize when the system bars hid and show
                    or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    // Hide the nav bar and status bar
                    or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_FULLSCREEN)
    }

    /**
     * Sets the app to full screen, system bars will be transparent when swiped.
     */
    private fun immersiveSticky() {
        requireActivity().window.decorView.systemUiVisibility =
            (View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                    // Set the content to appear under the system bar so that the content doesn't
                    // resize when the system bars hid and show
                    or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    // Hide the nav bar and status bar
                    or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_FULLSCREEN)
    }
}