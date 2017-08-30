package com.pablisco.smoothloading

import android.util.Log

fun <E : Throwable> Any.logException(
    exception: E,
    message: String = exception.message?:"No message"
) = Log.e(this.javaClass.simpleName, message, exception)