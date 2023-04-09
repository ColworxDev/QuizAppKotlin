package com.example.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.quizapp.databinding.ActivityProblem2DetailBinding

class Problem2DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProblem2DetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProblem2DetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val planets = resources.getStringArray(R.array.bookTitles)

        val adapter = ArrayAdapter<String>(this, com.google.android.material.R.layout.support_simple_spinner_dropdown_item, planets)
        binding.lview.adapter = adapter
        binding.lview.setOnItemClickListener { parent, view, position, id ->
            val item = parent.getItemAtPosition(position).toString()
            Toast.makeText(this,"$item Clicked", Toast.LENGTH_LONG).show()
        }

    }
}