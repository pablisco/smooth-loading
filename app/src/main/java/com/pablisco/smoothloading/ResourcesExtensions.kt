package com.pablisco.smoothloading

import android.content.Context
import android.content.res.Resources
import android.util.TypedValue.COMPLEX_UNIT_DIP
import android.util.TypedValue.applyDimension
import android.view.View

val View.colors: ColorSource
    get() = ColorSource(context)

val Context.colors: ColorSource
    get() = ColorSource(this)

val Context.strings: StringSource
    get() = StringSource(this)

fun Float.dp(): Float = applyDimension(COMPLEX_UNIT_DIP, this, Resources.getSystem().displayMetrics)

fun Int.dp(): Int = toFloat().dp().toInt()