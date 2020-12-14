package com.example.androiddevpractice.topics

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.transition.TransitionInflater
import com.example.androiddevpractice.MainActivityViewModel
import com.example.androiddevpractice.R
import com.example.androiddevpractice.TextSetup
import com.example.androiddevpractice.databinding.FragmentDetailsBinding


class DetailsFragment : Fragment() {

    private lateinit var binding: FragmentDetailsBinding
    private lateinit var topic: String
    private lateinit var textSetup: TextSetup
    private lateinit var viewModel: MainActivityViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val args = DetailsFragmentArgs.fromBundle(requireArguments())
        topic = args.Title
        sharedElementEnterTransition = TransitionInflater.from(context).inflateTransition(android.R.transition.move)

        viewModel = ViewModelProvider(requireActivity()).get(MainActivityViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_details, container, false)
        binding.tvTitle.text = topic

        textSetup = TextSetup()
        createTextView()

        return binding.root
    }

    fun createTextView() {
        val linear = binding.linearLayout

        viewModel.listTopic

//        viewModel.listTopic.observe(viewLifecycleOwner, Observer {
//            it?.let {
//                textSetup.createTextView2(requireContext(), it.toString() , linear )
//            }
//        })
//
        textSetup.createTextView2(requireContext(), viewModel.listTopic, linear)

    }
}