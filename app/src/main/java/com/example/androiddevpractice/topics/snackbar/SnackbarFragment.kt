package com.example.androiddevpractice.topics.snackbar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.androiddevpractice.R
import com.example.androiddevpractice.databinding.FragmentSnackbarBinding
import com.google.android.material.snackbar.Snackbar


class SnackbarFragment : Fragment() {

    lateinit var binding: FragmentSnackbarBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_snackbar, container, false)
        binding.binding = this

        return binding.root
    }

    fun launchSnackBar() {
        Snackbar.make(binding.coordinatorLayout, "This is my snack bar.", Snackbar.LENGTH_SHORT).apply {
            setAction("My Action", SnackbarAction())
            show()
        }



    }
}