package com.example.androiddevpractice.ui.details.topics.ui

import android.os.Bundle
import android.transition.TransitionManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.androiddevpractice.R
import com.example.androiddevpractice.databinding.FragmentPlaceHolderBinding


class PlaceHolderFragment : Fragment() {

    private lateinit var binding: FragmentPlaceHolderBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_place_holder, container, false)
        binding.binding = this
        return binding.root
    }

    fun swapViews(view: View) {
        TransitionManager.beginDelayedTransition(binding.constraint)
        binding.placeHolder.setContentId(view.id)
    }
}