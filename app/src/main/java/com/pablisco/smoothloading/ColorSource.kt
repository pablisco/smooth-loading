package com.pablisco.smoothloading

import android.content.Context
import android.support.annotation.ColorInt
import android.support.annotation.ColorRes
import android.support.v4.content.res.ResourcesCompat

class ColorSource(private val context: Context) {
    @ColorInt operator fun get(@ColorRes colourId: Int) : Int =
        ResourcesCompat.getColor(
            context.resources,
            colourId,
            context.theme
        )
}