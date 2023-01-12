package com.example.animations

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.AnimationUtils
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import com.example.animations.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val animation = AnimationUtils.loadAnimation(this@MainActivity, R.anim.circle_explosion_anim).apply {
            duration = 700
            interpolator = AccelerateDecelerateInterpolator()
        }

        binding.apply {
            recyclerview.adapter = ColorAdapter(colors)

            fab.setOnClickListener {
                fab.visibility = View.INVISIBLE
                circle.visibility = View.VISIBLE
                circle.startAnimation(animation) {
                    // display fragment
                    root.setBackgroundColor(ContextCompat.getColor(this@MainActivity, R.color.purple_500))
                    circle.visibility = View.INVISIBLE
                }
            }
        }
    }

    companion object {
        val colors = listOf(
            Color.BLUE,
            Color.RED,
            Color.YELLOW,
            Color.GREEN,
            Color.CYAN,
            Color.MAGENTA,
            Color.DKGRAY,
        )
    }
}