package com.pablisco.smoothloading

import android.animation.ArgbEvaluator
import android.animation.TypeEvaluator
import android.animation.ValueAnimator
import android.content.Context
import android.support.annotation.ColorRes

fun <T> createAnimator(
    evaluator: TypeEvaluator<*>,
    vararg values: T,
    onConfig: ValueAnimator.() -> Unit = {},
    onUpdate: (T) -> Unit
): ValueAnimator =
    ValueAnimator.ofObject(evaluator, *values).apply {
        addUpdateListener {
            @Suppress("UNCHECKED_CAST")
            onUpdate(it.animatedValue as T)
        }
        onConfig(this)
    }


fun Context.animateSmoothly(
    @ColorRes startColorId: Int,
    @ColorRes endColorId: Int,
    doUpdate: (Int) -> Unit
): ValueAnimator =
    createAnimator(
        ArgbEvaluator(),
        colors[startColorId],
        colors[endColorId],
        onConfig = {
            duration = 1000
            repeatMode = ValueAnimator.REVERSE
            repeatCount = ValueAnimator.INFINITE
            start()
        },
        onUpdate = doUpdate
    )
