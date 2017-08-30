package com.pablisco.smoothloading

import android.content.Context
import android.support.annotation.StringRes

class StringSource(private val context: Context) {
    operator fun get(@StringRes stringId: Int) : CharSequence =
        context.getString(stringId)
}