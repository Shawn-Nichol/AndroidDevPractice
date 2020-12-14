package com.example.androiddevpractice.topics.architecturecomponents

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.transition.TransitionInflater
import com.example.androiddevpractice.R
import com.example.androiddevpractice.TextSetup
import com.example.androiddevpractice.databinding.FragmentLifeCycleAwareBinding


class LifeCycleAwareFragment : Fragment() {

    private lateinit var binding: FragmentLifeCycleAwareBinding
    private lateinit var topic: String
    lateinit var textSetup: TextSetup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val args = DataBindingFragmentArgs.fromBundle(requireArguments())
        topic = args.Title
        sharedElementEnterTransition =
            TransitionInflater.from(context).inflateTransition(android.R.transition.move)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_life_cycle_aware,
            container,
            false
        )

        textSetup = TextSetup()
        createTextView()

        return binding.root
    }

    fun createTextView() {
        val linear = binding.linearLayout

        val details = arrayOf("ItemOne: \nLine2", "ItemTwo: \nLine2", "ItemThree: \nline 2")

        textSetup.createTextView(requireContext(), details, linear)

    }


}