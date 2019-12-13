package com.example.vectorframe

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.vectorframe.glide.loadWithGradient
import com.example.vectorframe.glide.loadWithSimpleFrame
import com.example.vectorframe.glide.loadWithTemplateFrame
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        iconImage.loadWithTemplateFrame(
            "https://pickaface.net/gallery/avatar/unr_sample_170130_2257_9qgawp.png",
            0.15f)

        iconImage2.loadWithSimpleFrame(
            "https://pickaface.net/gallery/avatar/20151109_144853_2380_sample.png")

        iconImage3.loadWithGradient(
            "https://static.amazon.jobs/locations/58/thumbnails/NYC.jpg?1547618123",
            R.color.startGradientColor,
            android.R.color.transparent)
    }
}