package com.example.androiddevpractice.ui.details.topics.ui

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.androiddevpractice.R
import com.example.androiddevpractice.databinding.FragmentToastBinding


class ToastFragment : Fragment() {

    private lateinit var binding: FragmentToastBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_toast, container, false)
        binding.binding = this

        return binding.root
    }


    fun launchToast() {
        val text = "This is my toast."
        val duration = if(binding.switchToastLength.isChecked) Toast.LENGTH_LONG else Toast.LENGTH_SHORT


        val toast =Toast.makeText(context, text, duration)
        toast.apply{
            when {
                binding.radioToastPositionCentered.isChecked -> {
                    setGravity(Gravity.CENTER_VERTICAL or Gravity.CENTER_HORIZONTAL, 0, 0)
                }
                binding.radioToastPositionTop.isChecked -> {
                    setGravity(Gravity.CENTER_VERTICAL or Gravity.CENTER_HORIZONTAL, 0, 0)
                }
                else -> {
                    // no position change
                }
            }
        }
        toast.show()
    }

    /**
     *  custom Toasts are deprecated as of API 30
     */
    fun launchCustomToast() {
        val inflater = layoutInflater
        val layout: View = inflater.inflate(
            R.layout.custom_toast,
            requireActivity().findViewById(R.id.custom_toast_container) as ViewGroup?
        )

         Toast(context).apply {
            duration = Toast.LENGTH_LONG
            setView(layout)
            setGravity(Gravity.CENTER_VERTICAL, 0, 0)
            show()
        }
    }
}