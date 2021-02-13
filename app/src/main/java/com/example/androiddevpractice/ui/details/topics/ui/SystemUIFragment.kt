package com.example.androiddevpractice.ui.details.topics.ui

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.*

import android.widget.RadioButton
import androidx.annotation.RequiresApi
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


    @RequiresApi(Build.VERSION_CODES.R)
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
                    noInsets()
                }

            }
        }
    }


    @RequiresApi(Build.VERSION_CODES.R)
    private fun dimStatusBar() {
        val controller = requireActivity().window.insetsController
        controller?.setSystemBarsAppearance(WindowInsetsController.APPEARANCE_LIGHT_NAVIGATION_BARS, WindowInsetsController.APPEARANCE_LIGHT_NAVIGATION_BARS)
//        controller?.controlWindowInsetsAnimation(WindowInsets.Type.statusBars(), 3000,null, null, )

    }

    @RequiresApi(Build.VERSION_CODES.R)
    private fun hideMyStatusBar() {

        val controller = requireActivity().window.insetsController
        controller?.systemBarsBehavior = WindowInsetsController.BEHAVIOR_SHOW_BARS_BY_TOUCH
        controller?.hide(WindowInsets.Type.statusBars())


    }

    @RequiresApi(Build.VERSION_CODES.R)
    private fun hideNavigationBar() {
        val controller = requireActivity().window.insetsController
        controller?.systemBarsBehavior = WindowInsetsController.BEHAVIOR_SHOW_BARS_BY_SWIPE
        controller?.hide(WindowInsets.Type.navigationBars())
    }

    /**
     * Sets the app to full screen, system bars will appear when the user taps on the screen.
     */
    @RequiresApi(Build.VERSION_CODES.R)
    private fun leanBack() {
        requireActivity().window.setDecorFitsSystemWindows(false)
        val controller = requireActivity().window.insetsController
        controller?.systemBarsBehavior = WindowInsetsController.BEHAVIOR_SHOW_BARS_BY_TOUCH
        controller?.hide(WindowInsets.Type.systemBars())
    }

    /**
     * Sets the app to full screen, system bars will appear when the user swipes down from the top.
     */
    @RequiresApi(Build.VERSION_CODES.R)
    private fun immersive() {
        val controller = requireActivity().window.insetsController
        controller?.systemBarsBehavior = WindowInsetsController.BEHAVIOR_SHOW_BARS_BY_SWIPE
        controller?.hide(WindowInsets.Type.systemBars())

    }

    /**
     * Sets the app to full screen, system bars will be transparent when swiped.
     */
    @RequiresApi(Build.VERSION_CODES.R)
    private fun immersiveSticky() {
        val controller = requireActivity().window.insetsController
        controller?.systemBarsBehavior = WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        controller?.hide(WindowInsets.Type.systemBars())

    }

    @RequiresApi(Build.VERSION_CODES.R)
    private fun noInsets() {
        Log.i("Practice", "NONE")
        requireActivity().window.insetsController?.show(WindowInsets.Type.statusBars())
    }
}