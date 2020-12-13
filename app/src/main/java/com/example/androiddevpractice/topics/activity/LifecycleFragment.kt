package com.example.androiddevpractice.topics.activity

import android.graphics.Color
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.AbsoluteSizeSpan
import android.text.style.ForegroundColorSpan
import android.transition.TransitionInflater
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.androiddevpractice.R
import com.example.androiddevpractice.databinding.FragmentActivityLifecycleBinding


class LifecycleFragment : Fragment() {

    private val TAG = "PracticeLifecycleFragment"

    private lateinit var binding: FragmentActivityLifecycleBinding
    private lateinit var topic: String

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
        val titleEnd = view.text.indexOf(")") + 1
        val end = view.text.length + 5
        showText(view, titleEnd, end)
    }

    fun showLoopText(view: View) {
        view as TextView
        val titleEnd = view.text.indexOf("life", 0,true) + 4
        val end = view.text.length
        showText(view, titleEnd, end)

    }

    fun showText(view: TextView, titleEnd: Int, end: Int) {
        val red = ForegroundColorSpan(Color.RED)
        val largeTextSize = AbsoluteSizeSpan(32, true)
        val smallTextSize = AbsoluteSizeSpan(14, true)

        val ssb = SpannableStringBuilder(view.text)

        if (view.maxLines == 1) {
            ssb.apply {
                setSpan(largeTextSize, 0, titleEnd, Spanned.SPAN_COMPOSING)
                setSpan(smallTextSize, (titleEnd), end, Spanned.SPAN_COMPOSING)
                setSpan(red, titleEnd, end, Spanned.SPAN_COMPOSING)
            }
            view.apply {
                maxLines = Int.MAX_VALUE
                text = ssb
            }
        } else {
            ssb.apply {
                setSpan(smallTextSize, 0, titleEnd, Spanned.SPAN_COMPOSING)
            }
            view.apply {
                maxLines = 1
                text = ssb
            }
        }
    }


}