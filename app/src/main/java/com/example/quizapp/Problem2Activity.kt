package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.quizapp.databinding.ActivityProblem2Binding

class Problem2Activity : AppCompatActivity() {

    private lateinit var binding: ActivityProblem2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProblem2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imageViewCategory0.setOnClickListener {
            startActivity(Intent(this, Problem2DetailActivity::class.java))
        }

        binding.imageViewCategory1.setOnClickListener {
            Toast.makeText(this, "Clothing image tapped", Toast.LENGTH_SHORT).show()
        }

        binding.imageViewCategory2.setOnClickListener {
            startActivity(Intent(this, Problem3ListView::class.java))
        }

        binding.imageViewCategory3.setOnClickListener {
            Toast.makeText(this, "Medicines image tapped", Toast.LENGTH_SHORT).show()
        }
    }

}