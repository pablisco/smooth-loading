package com.pablisco.smoothloading

import android.app.Application
import com.bumptech.glide.Glide
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.launch

class SmoothApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        launch(CommonPool) {
            Glide.get(applicationContext).clearDiskCache()
        }
    }

}