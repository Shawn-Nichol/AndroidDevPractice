package com.example.androiddevpractice.topics.activity

import android.os.Bundle
import android.transition.TransitionInflater
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.androiddevpractice.R
import com.example.androiddevpractice.databinding.FragmentSavingPersistentStateBinding


class SavingPersistentStateFragment : Fragment() {
    private lateinit var binding: FragmentSavingPersistentStateBinding
    private lateinit var topic: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val args = SavingPersistentStateFragmentArgs.fromBundle(requireArguments())
        topic = args.Title
        sharedElementEnterTransition = TransitionInflater.from(context).inflateTransition(android.R.transition.move)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_saving_persistent_state, container, false)
        binding.tvTitle.text = topic

        return binding.root
    }
}