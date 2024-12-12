package com.example.gradecalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)

        val num1 = findViewById<EditText>(R.id.prelimGrade)
        val num2 = findViewById<EditText>(R.id.midtermGrade)
        val num3 = findViewById<EditText>(R.id.finalGrade)
        val ave = findViewById<TextView>(R.id.gradeAverage)
        val comp = findViewById<Button>(R.id.btnCompute)
        comp.setOnClickListener {
            val grade1 = num1.text.toString().toInt()
            val grade2 = num2.text.toString().toInt()
            val grade3 = num3.text.toString().toInt()

            val average = ( (grade1 * 0.30) + (grade2 * 0.30) + (grade3 * 0.40) )
            val twoDecimal = String.format("%.2f", average)

            ave.text = twoDecimal
        }

        val btnAlert = findViewById<Button>(R.id.btnClose)
        btnAlert.setOnClickListener {
            val alertDialogBuilder = AlertDialog.Builder(this@MainActivity2)

            alertDialogBuilder.setMessage("Are you sure you want to exit?")
            alertDialogBuilder.setTitle("Confirm Exit")
            alertDialogBuilder.setCancelable(false)
            alertDialogBuilder.setPositiveButton("Yes") { dialog,which ->
                finish()
                dialog.dismiss()
            }

            alertDialogBuilder.setNegativeButton("No") { dialog,which ->
                dialog.dismiss()
            }

            val alertDialogBox = alertDialogBuilder.create()
            alertDialogBox.show()

        }

    }
}