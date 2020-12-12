package com.example.androiddevpractice.topics.activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.transition.TransitionInflater
import com.example.androiddevpractice.R
import com.example.androiddevpractice.databinding.FragmentConfigurationChangeBinding


class ConfigurationChangeFragment : Fragment() {

    private lateinit var binding: FragmentConfigurationChangeBinding


    private lateinit var topic: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val args = ConfigurationChangeFragmentArgs.fromBundle(requireArguments())
        topic = args.Title
        sharedElementEnterTransition = TransitionInflater.from(context).inflateTransition(android.R.transition.move)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_configuration_change, container, false)
        binding.tvTitle.text = topic


        return binding.root
    }
}