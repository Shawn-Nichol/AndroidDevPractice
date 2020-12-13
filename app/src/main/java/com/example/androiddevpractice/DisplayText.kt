package com.example.androiddevpractice

import android.graphics.Color
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.AbsoluteSizeSpan
import android.text.style.ForegroundColorSpan
import android.widget.TextView

/**
 * DisplayText is used to show and hide the description of text.
 */
class DisplayText () {

    fun showText(view: TextView, endString: String){
        val titleEnd = view.text.indexOf(endString, 0,true) + endString.length
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