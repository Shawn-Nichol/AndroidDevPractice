package com.example.androiddevpractice.topics.activity

import android.os.Bundle
import android.transition.TransitionInflater
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.androiddevpractice.topics.TextSetup
import com.example.androiddevpractice.R
import com.example.androiddevpractice.databinding.FragmentActivityLifecycleBinding


class LifecycleFragment : Fragment() {

    private val TAG = "PracticeLifecycleFragment"

    private lateinit var binding: FragmentActivityLifecycleBinding
    private lateinit var topic: String
    var display = TextSetup()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val args = LifecycleFragmentArgs.fromBundle(requireArguments())
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
            R.layout.fragment_activity_lifecycle,
            container,
            false
        )
        binding.binding = this
        binding.tvTitle.text = topic

        return binding.root
    }

    fun showLifeCycleText(view: View) {
        view as TextView
        display.showHideText(view)
    }
}