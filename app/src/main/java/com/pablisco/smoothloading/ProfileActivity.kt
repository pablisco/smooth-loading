package com.pablisco.smoothloading

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity() {

    private val placeholderUrl = "https://www.fillmurray.com/3000/3000"

    private val imageViewBackground
        by lazy { ColorDrawable() }
    private val titleViewBackground
        by lazy { TextLoadingBackground(titleView) }
    private val subtitleViewBackground
        by lazy { TextLoadingBackground(subtitleView) }
    private val descriptionViewBackground
        by lazy { TextLoadingBackground(descriptionView) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
    }

    override fun onStart() {
        super.onStart()

        imageView.background = imageViewBackground
        titleView.background = titleViewBackground
        subtitleView.background = subtitleViewBackground
        descriptionView.background = descriptionViewBackground

        val animation = animateSmoothly(
            R.color.loading_animation_start,
            R.color.loading_animation_end,
            this::setViewsBackgroundColor
        )

        imageView.setImageUrl(placeholderUrl) {
            animation.cancel()

            setViewsBackgroundColor(0)
            titleView.text = strings[R.string.title]
            subtitleView.text = strings[R.string.subtitle]
            descriptionView.text = strings[R.string.description]
        }

    }

    private fun setViewsBackgroundColor(color: Int) {
        imageViewBackground.color = color
        titleViewBackground.color = color
        subtitleViewBackground.color = color
        descriptionViewBackground.color = color
    }

}
