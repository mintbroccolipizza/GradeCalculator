package com.example.gradecalculator

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {


    @SuppressLint("DefaultLocale")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)

        val prelim = findViewById<EditText>(R.id.prelimGrade)
        val midterm = findViewById<EditText>(R.id.midtermGrade)
        val finals = findViewById<EditText>(R.id.finalGrade)
        val ave = findViewById<TextView>(R.id.gradeAverage)
        val comp = findViewById<Button>(R.id.btnCompute)
        val clearTxt = findViewById<Button>(R.id.btnClear)

        comp.setOnClickListener {
            val grade1 = prelim.text.toString().toInt()
            val grade2 = midterm.text.toString().toInt()
            val grade3 = finals.text.toString().toInt()

            //set only up to 100 grade input
            if(prelim.text.isEmpty() || midterm.text.isEmpty() || finals.text.isEmpty()){
                Toast.makeText(this, "Error: Fill prelim, midterm, and final grade to compute", Toast.LENGTH_LONG).show()
            }
            if(grade1 > 100 || grade1 < 0 || grade2 > 100 || grade2 < 0 || grade3 > 100 || grade3 < 0){
                Toast.makeText(this, "Error: Enter number between 0 and 100 only", Toast.LENGTH_LONG).show()
            }else{
                val average = ( (grade1 * 0.30) + (grade2 * 0.30) + (grade3 * 0.40) )
                val twoDecimal = String.format("%.2f", average)

                ave.text = twoDecimal
            }

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

        clearTxt.setOnClickListener{

            prelim.setText("")
            midterm.setText("")
            finals.setText("")

        }

    }
}