package com.example.gradecalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val btnSystem = findViewById<Button>(R.id.btnSystem)
        btnSystem.setOnClickListener {
            val intent = Intent(this,MainActivity2::class.java)
            startActivity(intent)
        }

        val btnAlert = findViewById<Button>(R.id.btnExit)
        btnAlert.setOnClickListener {
            val alertDialogBuilder = AlertDialog.Builder(this@MainActivity)

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