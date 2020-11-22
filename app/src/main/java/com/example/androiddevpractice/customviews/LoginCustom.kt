package com.example.androiddevpractice.customviews

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import androidx.core.content.withStyledAttributes
import com.example.androiddevpractice.R
import kotlin.math.cos
import kotlin.math.sin

class LoginCustom(context: Context, attrs: AttributeSet) : View(context, attrs) {

    // Canvas measurements
    var radius: Float = 0.0f
    var centerX = 0.0f
    var centerY = 0.0f
    var borderWidth = 10.0f

    // paint info
    private val paintCircle = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.GREEN
        style = Paint.Style.FILL
        isAntiAlias = true
        isDither = true
    }

    private val paintText = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.CYAN
        style = Paint.Style.FILL_AND_STROKE
        textSize = 200.0f
        strokeWidth = 10.0f
        textAlign = Paint.Align.CENTER
    }

    private val paintBoarder = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.BLACK
        style = Paint.Style.STROKE
        strokeWidth = borderWidth
    }

    // Attribute values
    private var color1 = 0
    private var color2 = 0
    private var color3 = 0
    private var color4 = 0
    private var showText = false

    // Click values
    var centerText = "0"

    init {
        isClickable = true

        context.withStyledAttributes(attrs, R.styleable.LoginView) {
            color1 = getColor(R.styleable.LoginView_color1, 0)
            color2 = getColor(R.styleable.LoginView_color2, 0)
            color3 = getColor(R.styleable.LoginView_color3, 0)
            showText = getBoolean(R.styleable.LoginView_showText, false)

        }
    }

    override fun performClick(): Boolean {
        if (super.performClick()) return true

        when (centerText) {
            "0", "9" -> {
                centerText = "4"
                paintCircle.color = color1
                showText = true
            }
            "4" -> {
                centerText = "3"
                paintCircle.color = color2
            }
            "3" -> {
                centerText = "6"
                paintCircle.color = color3
            }
             "6"-> {
                 centerText = "9"
                 paintCircle.color = color4
             }
        }
        invalidate()
        return true
    }

    /**
     *  Called on initial load to check the size of the view, then only called if the view size
     *  is changed.
     */
    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        radius = (Integer.min(w, h) / 2 * 0.8).toFloat()
        centerX = width / 2.0f
        centerY = height / 2.0f
    }

    /**
     * onDraw does the drawing of
     * @Canvas The canvas on which the background will be drawn.
     */
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        drawCircle(canvas)
        drawX(canvas)
        drawText(canvas)
    }


    fun drawCircle(canvas: Canvas) {
        /**
         * drawCircle
         * cx: the center position of x
         * cy: the center position of y
         * radius: The radius of the circle
         * Paint: the paint used to draw the circle.
         */
        canvas.drawCircle(centerX, centerY, radius, paintCircle)
        canvas.drawCircle(centerX, centerY, radius, paintBoarder)
    }

    fun drawX(canvas: Canvas) {
        var startAngle = 45.0
        var endAngle = 225.0
        var startX = centerX + (cos(Math.toRadians(startAngle)) * radius).toFloat()
        var startY = centerY + (sin(Math.toRadians(startAngle)) * radius).toFloat()
        var endX = centerX + (cos(Math.toRadians(endAngle)) * radius).toFloat()
        var endY = centerY + (sin(Math.toRadians(endAngle)) * radius).toFloat()

        /**
         * startX: The x-coordinate of the start point of the line.
         * startY: the y-coordinate of the start point of the line.
         * stopX:
         * stopY:
         * paint: The paint used to draw the line.
         */
        canvas.drawLine(startX, startY, endX, endY, paintBoarder)


        centerX = width / 2.0f
        centerY = height / 2.0f
        startAngle = 135.0
        endAngle = 315.0
        startX = centerX + (cos(Math.toRadians(startAngle)) * radius).toFloat()
        startY = centerY + (sin(Math.toRadians(startAngle)) * radius).toFloat()
        endX = centerX + (cos(Math.toRadians(endAngle)) * radius).toFloat()
        endY = centerY + (sin(Math.toRadians(endAngle)) * radius).toFloat()
        canvas.drawLine(startX, startY, endX, endY, paintBoarder)
    }

    fun drawText(canvas: Canvas) {
        if (showText) {
            val startY = centerY - ((paintText.descent() + paintText.ascent()) / 2)
            canvas.drawText(centerText, centerX, startY, paintText)
        }
    }
}
