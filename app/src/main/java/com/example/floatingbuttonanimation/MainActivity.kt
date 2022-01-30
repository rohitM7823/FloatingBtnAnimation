package com.example.floatingbuttonanimation

import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.example.floatingbuttonanimation.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val rotateOpen: Animation by lazy {
        AnimationUtils.loadAnimation(
            this,
            R.anim.rotate_open
        )
    }
    private val rotateClose: Animation by lazy {
        AnimationUtils.loadAnimation(
            this,
            R.anim.rotate_close
        )
    }
    private val fromBtn: Animation by lazy {
        AnimationUtils.loadAnimation(
            this,
            R.anim.from_button
        )
    }
    private val toBtn: Animation by lazy { AnimationUtils.loadAnimation(this, R.anim.to_button) }
    private var isClicked = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.addBtn.setOnClickListener {
            animateButtons()
        }
        binding.askCommunity.setOnClickListener {
            Snackbar.make(it,"Ask Community Button Clicked", Snackbar.LENGTH_SHORT).show()
        }
        binding.askCropDoctor.setOnClickListener {
            Snackbar.make(it, "Ask Crop Doctor Button Clicked", Snackbar.LENGTH_SHORT).show()
        }
    }

    private fun animateButtons() {
        setAnimation()
        setVisibility()
        isClicked = !isClicked
    }

    private fun setVisibility() {
        if (!isClicked) {
            binding.askCommunity.visibility = View.INVISIBLE
            binding.askCropDoctor.visibility = View.INVISIBLE
        } else {
            binding.askCommunity.visibility = View.VISIBLE
            binding.askCropDoctor.visibility = View.VISIBLE
        }
    }

    private fun setAnimation() {
        if (!isClicked) {
            binding.askCommunity.startAnimation(toBtn)
            binding.askCropDoctor.startAnimation(toBtn)
            binding.addBtn.startAnimation(rotateClose)
        } else {
            binding.askCropDoctor.startAnimation(fromBtn)
            binding.askCommunity.startAnimation(fromBtn)
            binding.addBtn.startAnimation(rotateOpen)
        }
    }


}