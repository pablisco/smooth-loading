package com.pablisco.smoothloading

import android.graphics.drawable.Drawable
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target

fun ImageView.setImageUrl(
    url: String,
    onFinish: () -> Unit = {}
) {
    Glide.with(this)
        .load(url)
        .listener(RequestListenerAdapter<Drawable>(onFinish))
        .into(this)
}

internal class RequestListenerAdapter<T>(
    private val onFinish: () -> Unit
) : RequestListener<T> {

    override fun onResourceReady(resource: T, model: Any?, target: Target<T>?, dataSource: DataSource?, isFirstResource: Boolean): Boolean {
        onFinish()
        return false
    }

    override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<T>?, isFirstResource: Boolean): Boolean {
        onFinish()
        logException(e?:GlideException("No glide exception provided"))
        return false
    }

}
