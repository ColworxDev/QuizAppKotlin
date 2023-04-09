package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.quizapp.databinding.ActivityStartBinding

class StartActivity : AppCompatActivity() {
    private lateinit var binding: ActivityStartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStartBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun onClickButton1(view: View) {
        startActivity(Intent(this, Problem1Activity::class.java))
    }

    fun onClickButton2(view: View) {
        startActivity(Intent(this, Problem2Activity::class.java))
    }

}