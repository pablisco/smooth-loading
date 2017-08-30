package com.pablisco.smoothloading

import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.graphics.drawable.ColorDrawable
import android.widget.TextView

class TextLoadingBackground(
    private val view: TextView
) : ColorDrawable() {

    private val paintArea = view.paintArea
    private val paint = Paint()

    override fun draw(canvas: Canvas) {
        paintArea.right = canvas.width - view.paddingRight
        canvas.drawRect(paintArea, paint)
    }

    override fun setColor(color: Int) {
        super.setColor(color)
        paint.color = color
    }

    private val TextView.fontHeight: Int
        get() = with(paint.fontMetrics) { bottom - top }.toInt()

    private val TextView.paintArea: Rect
        get() = Rect(
            paddingLeft,
            paddingTop,
            0,
            paddingTop + fontHeight - paddingBottom
        )

}