package com.example.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.quizapp.databinding.ActivityProblem3DetailBinding

class Problem3DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProblem3DetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProblem3DetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (intent.hasExtra("image") && intent.hasExtra("name") && intent.hasExtra("detail")) {
            var ig = intent.getIntExtra("image", 0)
            var t1 = intent.getStringExtra("name")
            var t2 = intent.getStringExtra("detail")
            binding.name.text = t1.toString()
            binding.desc.text = t2.toString()
            binding.imageView.setImageResource(ig)
        }
    }
}