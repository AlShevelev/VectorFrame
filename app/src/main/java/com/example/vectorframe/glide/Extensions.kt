package com.example.vectorframe.glide

import android.content.res.Resources
import android.os.Build
import android.widget.ImageView
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.annotation.DimenRes
import androidx.annotation.DrawableRes
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestOptions
import com.example.vectorframe.R

fun ImageView.loadWithTemplateFrame(
    url: String?,
    percentage: Float,
    @ColorRes percentAreaColor: Int = R.color.frameColor,
    @DrawableRes frameTemplate: Int = R.drawable.ic_ellipse) =
    Glide
        .with(this)
        .load(url)
        .transform(
            CircleCrop(),
            PercentageRoundVectorFrameTransformation(
                this.context.applicationContext,
                0.8f,
                percentage,
                percentAreaColor,
                frameTemplate
            ))
        .into(this)

fun ImageView.loadWithSimpleFrame(
    url: String?,
    @DimenRes
    strokeWidthResId: Int = R.dimen.stroke,
    @ColorRes
    frameColorResId: Int = R.color.frameColor) =
    Glide
        .with(this)
        .load(url)
        .transform(
            CircleCrop(),
            RoundFrameTransformation(
                this.context.applicationContext,
                strokeWidthResId,
                frameColorResId
            ))
        .into(this)

fun ImageView.loadWithGradient(
    url: String?,
    @ColorRes
    startColor: Int,
    @ColorRes
    endColor: Int) =
    Glide
        .with(this)
        .load(url)
        .transform(
            CenterCrop(),
            GradientTransformation(
                this.context.applicationContext,
                startColor,
                endColor
            ))
        .into(this)


fun ImageView.loadLarge(url: String?) {
    Glide
        .with(this)
        .applyDefaultRequestOptions(RequestOptions.centerCropTransform())
        .load(url)
        .into(this)
}

@Suppress("DEPRECATION")
@ColorInt
fun Resources.getColorRes(@ColorRes resId: Int): Int =
    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        this.getColor(resId, null)
    } else {
        this.getColor(resId)
    }
