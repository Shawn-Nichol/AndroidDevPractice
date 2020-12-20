package com.example.androiddevpractice.topics

import android.content.Context
import android.graphics.Typeface
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.widget.LinearLayoutCompat
import com.example.androiddevpractice.R

/**
 * DisplayText is used to show and hide the description of text.
 */
class TextSetup(val context: Context) {

    val TAG: String = "PracticeTextSetup"

    private lateinit var linear: LinearLayoutCompat
    lateinit var params: LinearLayoutCompat.LayoutParams

    fun createTextView(details: List<String>, linear: LinearLayoutCompat) {
        this.linear = linear
        // Create a views for each item in the list.
        for (i in details.indices) {
            val item = details[i]

            if (i == 0) summaryString(item)
            else {
                setTitle(item, i)
                setInfo(item, i)
            }
        }
    }

    private fun summaryString(summaryText: String) {
        val textView: TextView = setTextView(summaryText)
        setMargin(true)
        linear.addView(textView, params)
    }

    private fun setTitle(item: String, pos: Int) {
        val titleEnd = item.indexOf(":")
        val title = item.substring(0, titleEnd)
        val titleTextView = setTextView(title).apply {
            paint.isUnderlineText = true
            typeface = Typeface.DEFAULT_BOLD
            setOnClickListener {
                val showTextView = linear.findViewWithTag<TextView>(pos + 1000)
                Log.i(TAG, "ViewTAG: ${showTextView.tag}")

                if(showTextView.visibility == 0) {
                    showTextView.visibility = View.GONE
                    textSize = 14f
                } else {
                    showTextView.visibility = View.VISIBLE
                    textSize = 24f
                }
            }
        }

        setMargin(true)
        linear.addView(titleTextView, params)

    }

    private fun setInfo(item: String, pos: Int) {

        val infoStart = item.indexOf(":") + 1
        val info = item.substring(infoStart)
        val infoTextView = setTextView(info).apply {
            tag = pos + 1000
            text
            visibility = View.GONE
        }


        Log.i(TAG, "setInfo, infoTextView Tag: ${infoTextView.tag}")
        setMargin(false)
        linear.addView(infoTextView, params)

    }

    private fun setMargin(marginTop: Boolean) {
        params = LinearLayoutCompat.LayoutParams(
            LinearLayoutCompat.LayoutParams.MATCH_PARENT,
            LinearLayoutCompat.LayoutParams.MATCH_PARENT
        )
        params.apply {
            marginStart = context.resources.getDimensionPixelSize(R.dimen.default_start)
            topMargin = if (marginTop) {
                context.resources.getDimensionPixelSize(R.dimen.default_top)
            } else 0
            marginEnd = context.resources.getDimensionPixelSize(R.dimen.default_end)
            bottomMargin = 0
        }
    }

    /**
     * Sets the default Attributes for the textViews.
     */
    private fun setTextView(string: String): TextView {
        return TextView(context).apply {
            text = string
            textSize = 14f
            textAlignment = View.TEXT_ALIGNMENT_TEXT_START
        }
    }
}