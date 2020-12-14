package com.example.androiddevpractice

import android.content.Context
import android.graphics.Color
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.AbsoluteSizeSpan
import android.text.style.ForegroundColorSpan
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.lifecycle.LiveData

/**
 * DisplayText is used to show and hide the description of text.
 */
class TextSetup() {

    val TAG: String =  "PracticeTextSetup"

    fun createTextView2(context: Context, details: LiveData<List<String>>, linear: LinearLayoutCompat) {
        Log.i(TAG, "CreateText2, Size: ${listOf(details).size}")

        listOf(details).size
        for (i in 0..listOf(details).size) {
            Log.i(TAG, "i = $i, Text = ${listOf(details)[i]}")

            var myText: TextView = TextView(context)
            myText.apply {
                setOnClickListener { showHideText(myText) }
                text = listOf(details)[i].toString()
                textSize = 14f
                textAlignment = View.TEXT_ALIGNMENT_TEXT_START
                maxLines = 1
            }

            // Every single ViewGroup needs to store information about its children's properties. About
            // the way its children are being laid out in the ViewGroup. This information i stored in objects
            // of a wrapper class.
            val params: LinearLayoutCompat.LayoutParams = LinearLayoutCompat.LayoutParams(
                LinearLayoutCompat.LayoutParams.MATCH_PARENT,
                LinearLayoutCompat.LayoutParams.MATCH_PARENT
            )

            params.setMargins(
                context.resources.getDimensionPixelSize(R.dimen.default_start),
                context.resources.getDimensionPixelSize(R.dimen.default_top),
                context.resources.getDimensionPixelSize(R.dimen.default_end),
                0
            )

            linear.addView(myText, params)
        }
    }


    fun createTextView(context: Context, details: Array<String>, linear: LinearLayoutCompat) {
        for (i in details.indices) {


            var myText: TextView = TextView(context)
            myText.apply {
                setOnClickListener { showHideText(myText) }
                text = details[i]
                textSize = 14f
                textAlignment = View.TEXT_ALIGNMENT_TEXT_START
                maxLines = 1
            }

            // Every single ViewGroup needs to store information about its children's properties. About
            // the way its children are being laid out in the ViewGroup. This information i stored in objects
            // of a wrapper class.
            val params: LinearLayoutCompat.LayoutParams = LinearLayoutCompat.LayoutParams(
                LinearLayoutCompat.LayoutParams.MATCH_PARENT,
                LinearLayoutCompat.LayoutParams.MATCH_PARENT
            )

            params.setMargins(
                context.resources.getDimensionPixelSize(R.dimen.default_start),
                context.resources.getDimensionPixelSize(R.dimen.default_top),
                context.resources.getDimensionPixelSize(R.dimen.default_end),
                0
            )

            linear.addView(myText, params)

        }
    }

    fun showHideText(view: TextView) {
        val titleEnd = view.text.indexOf(":", 0, true) + 1
        val end = view.text.length

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