package com.example.quizapp

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.quizapp.databinding.ActivityProblem1Binding
import com.example.quizapp.databinding.ActivityStartBinding
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

class Problem1Activity : AppCompatActivity() {

    private lateinit var binding: ActivityProblem1Binding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProblem1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.radioGroup1.setOnCheckedChangeListener { radioGroup, i ->
            println(i)
        }

    }

    fun onClickButtonSubmit(view: View) {

        var points = 0
        var title = "Unfortunately"
        //check only option 1 is selected
        if (binding.radioGroup1.checkedRadioButtonId == R.id.radiobutton1) {
            points += 50
        }
        //check only answer 1,2 is selected
        if (binding.checkbox1.isChecked && binding.checkbox2.isChecked && !binding.checkbox3.isChecked) {
            points += 50
        }

        if (points > 0) {
            title = "Congratulations"
        }
        val formatter = SimpleDateFormat("yyyy-MMM-dd hh:mm a")
        val current = formatter.format(Date())

        val msg = "You submitted on $current, You achieved $points%”"
        showAlert(title, msg)
    }

    fun showAlert(title: String, msg: String) {
        val builder = AlertDialog.Builder(this)
        // 2. Set the basic information for the builder object
        builder.setTitle(title)
        builder.setMessage(msg)
        builder.setPositiveButton("Ok"){dialogInterface, which ->
            //dialogInterface.dismiss() // dismiss the dialog
            //finish() // to destroy the activity
        }
        // 5. Finally, make the alert dialog using builder
        val dialog: AlertDialog = builder.create()
        // 6. Display the alert dialog on app interface
        dialog.show()
    }

    fun onClickButtonReset(view: View) {
        binding.radioGroup1.clearCheck()
        arrayOf(binding.checkbox1, binding.checkbox2, binding.checkbox3).forEach { it.isChecked = false }
    }
}