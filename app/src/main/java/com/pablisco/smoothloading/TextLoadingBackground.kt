package com.pablisco.smoothloading

import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.graphics.drawable.ColorDrawable
import android.widget.TextView

class TextLoadingBackground(
    private val view: TextView
) : ColorDrawable() {

    private val paintArea = view.textBounds()
    private val paint = Paint()

    override fun draw(canvas: Canvas) {
        paintArea.right = canvas.width - view.paddingRight
        canvas.clipRect(paintArea)
        super.draw(canvas)
    }

    override fun setColor(color: Int) {
        super.setColor(color)
        paint.color = color
    }

    private fun TextView.textBounds() =
        Rect(paddingLeft, paddingTop, 0, textBottom)

    private val TextView.textBottom
        get() = paddingTop + paint.fontMetrics.height - paddingBottom

    private val Paint.FontMetrics.height: Int
        get() = (bottom - top).toInt()

}