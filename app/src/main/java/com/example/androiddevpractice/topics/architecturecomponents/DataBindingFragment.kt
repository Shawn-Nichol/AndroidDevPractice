package com.example.androiddevpractice.topics.architecturecomponents

import android.os.Bundle
import android.transition.TransitionInflater
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.androiddevpractice.TextSetup
import com.example.androiddevpractice.R
import com.example.androiddevpractice.databinding.FragmentDatabindingBinding


class DataBindingFragment : Fragment() {

    private lateinit var binding: FragmentDatabindingBinding
    private lateinit var topic: String
    val display = TextSetup()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val args = DataBindingFragmentArgs.fromBundle(requireArguments())
        topic = args.Title
        sharedElementEnterTransition = TransitionInflater.from(context).inflateTransition(android.R.transition.move)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_databinding, container, false)
        binding.binding = this


        return binding.root
    }

    fun showText(view: View) {
        view as TextView
        display.showHideText(view)
    }

}