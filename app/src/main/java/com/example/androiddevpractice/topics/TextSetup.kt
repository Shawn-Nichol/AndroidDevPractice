package com.example.androiddevpractice.topics

import android.content.Context
import android.graphics.Typeface
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.navigation.findNavController
import com.example.androiddevpractice.R

/**
 * DisplayText is used to show and hide the description of text.
 */
class TextSetup(val context: Context) {

    val TAG: String = "PracticeTextSetup"

    private lateinit var linear: LinearLayoutCompat
    lateinit var params: LinearLayoutCompat.LayoutParams


    // Constants
    val TOP_MARGIN_YES = 0
    val TOP_MARGIN_NO = 1


    fun createTextView(details: List<String>, linear: LinearLayoutCompat) {
        this.linear = linear
        // Create a views for each item in the list.
        for (i in details.indices) {
            val item = details[i]

            if (i == 0) summaryString(item)
            else {
                setTitle(item, i)
                setInfo(item, i)
                loadExample(item, i)
            }
        }
    }

    /**
     * Displays the summary text of the the selected Topic
     */
    private fun summaryString(summaryText: String) {
        val textView: TextView = setTextView(summaryText)
        setMargin(TOP_MARGIN_YES)
        linear.addView(textView, params)
    }


    private fun setString(item: String, pos: Int, start: Char, end: String) {
        val startString = item.indexOf(start)
        val endString = item.indexOf(end)
        val parsedString = item.substring(startString, endString)

        val textView = setTextView(parsedString).apply {

        }
    }

    /**
     * Shows details title, This title is clickable and will display the infoText when clicked.
     */
    private fun setTitle(item: String, pos: Int) {
        val titleEnd = item.indexOf(":")
        val title = item.substring(0, titleEnd)
        val titleTextView = setTextView(title).apply {
            paint.isUnderlineText = true
            typeface = Typeface.DEFAULT_BOLD
            setOnClickListener {
                val showTextView = linear.findViewWithTag<TextView>(pos + 1000)

                Log.i(TAG, "ViewTAG: ${showTextView.tag}")

                if (showTextView.visibility == 0) {
                    showTextView.visibility = View.GONE


                    // Text size of title
                    textSize = 14f
                } else {
                    showTextView.visibility = View.VISIBLE

                    // TextSize of title
                    textSize = 24f
                }

                if(linear.findViewWithTag<TextView>("example $pos") == null) {
                    val exampleTextView = linear.findViewWithTag<TextView>("example $pos")

                    if (showTextView.visibility == 0) {
                        exampleTextView.visibility = View.VISIBLE
                    } else exampleTextView.visibility = View.GONE
                }
            }
        }

        setMargin(TOP_MARGIN_YES)
        linear.addView(titleTextView, params)
    }

    /**
     * Shows the info the title text.
     */
    private fun setInfo(item: String, pos: Int) {
        // Get the position of the : and add one
        val infoStart = item.indexOf(":") + 1
        // This is where the string starts
        val info = item.substring(infoStart)
        val infoTextView = setTextView(info).apply {
            tag = pos + 1000
            visibility = View.GONE
        }

        Log.i(TAG, "setInfo, infoTextView Tag: ${infoTextView.tag}")
        setMargin(TOP_MARGIN_NO)
        linear.addView(infoTextView, params)

    }

    fun loadExample(topic: String, pos: Int) {
        if(topic.contains("***")) {
            Log.i(TAG, "loadExample no example.")
            return
        }
        val examplePos = topic.indexOf("Button")

        Log.i(TAG, "Position $examplePos, Topic: ${topic.length}")
        val navString = topic.substring(examplePos)
        val exampleText = setTextView("Example").apply {
            tag = "example $pos"
            visibility = View.GONE
            setOnClickListener {
                Log.i(TAG, "load example")
                navigate(it, navString)
            }
        }

        setMargin(TOP_MARGIN_NO)
        linear.addView(exampleText, params)
    }

    private fun setMargin(margin: Int) {
        params = LinearLayoutCompat.LayoutParams(
            LinearLayoutCompat.LayoutParams.MATCH_PARENT,
            LinearLayoutCompat.LayoutParams.MATCH_PARENT
        )
        params.apply {
            marginStart = context.resources.getDimensionPixelSize(R.dimen.default_start)

            topMargin = if (margin == TOP_MARGIN_YES) {
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

    private fun navigate(view: View, navString: String) {
        when (navString) {
            "Button" -> view.findNavController().navigate(R.id.dest_buttonFragment)
        }
    }

}