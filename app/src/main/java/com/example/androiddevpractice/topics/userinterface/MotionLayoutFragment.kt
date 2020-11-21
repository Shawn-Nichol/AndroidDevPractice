package com.example.androiddevpractice.topics.userinterface

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.androiddevpractice.R
import com.example.androiddevpractice.databinding.FragmentMotionLayoutBinding


class MotionLayoutFragment : Fragment() {

    private lateinit var binding: FragmentMotionLayoutBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_motion_layout, container, false)

        return binding.root
    }
}