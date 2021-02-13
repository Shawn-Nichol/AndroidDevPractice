package com.example.androiddevpractice.ui.details.topics.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.androiddevpractice.R
import com.example.androiddevpractice.databinding.FragmentConstraintLayoutBinding


class ConstraintLayoutFragment : Fragment() {

    private val TAG = "ConstraintLayoutFragment"
    private lateinit var binding: FragmentConstraintLayoutBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_constraint_layout, container, false)
        Log.i(TAG, "onCreateView")
        return binding.root
    }
}