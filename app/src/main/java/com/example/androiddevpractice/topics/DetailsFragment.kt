package com.example.androiddevpractice.topics

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.transition.TransitionInflater
import com.example.androiddevpractice.MainActivityViewModel
import com.example.androiddevpractice.R
import com.example.androiddevpractice.databinding.FragmentDetailsBinding


class DetailsFragment : Fragment() {

    private lateinit var binding: FragmentDetailsBinding
    private lateinit var topic: String
    private lateinit var textSetup: TextSetup
    private lateinit var viewModel: MainActivityViewModel



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedElementEnterTransition = TransitionInflater.from(context).inflateTransition(android.R.transition.move)

        val args = DetailsFragmentArgs.fromBundle(requireArguments())
        topic = args.Title

        viewModel = ViewModelProvider(requireActivity()).get(MainActivityViewModel::class.java)
        viewModel.selectTopic(topic, args.Category)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_details, container, false)
        binding.tvTitle.text = topic

        textSetup = TextSetup(requireContext())
        createTextView()

        return binding.root
    }

    fun createTextView() {
        val linear = binding.linearLayout
        viewModel.listTopic.observe(viewLifecycleOwner, Observer {
            it?.let {
                textSetup.createTextView2(it, linear)
            }
        })
    }
}