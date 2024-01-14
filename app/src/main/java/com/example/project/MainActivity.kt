package com.example.project

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val pButton: Button = findViewById(R.id.bPhone)
        val eButton: Button = findViewById(R.id.bEmail)
        pButton.setOnClickListener {
            val number = "23454568678"
            val intent = Intent(Intent.ACTION_CALL)
            intent.data = Uri.parse("tel:$number")
            startActivity(intent)
        }
        eButton.setOnClickListener {
            //var editTextHello = findViewById(R.id.editTextTextEmailAddress2) as EditText
            //Toast.makeText(this, "${editTextHello.text}", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, emailSender::class.java)
            startActivity(intent)
        }

    }
}