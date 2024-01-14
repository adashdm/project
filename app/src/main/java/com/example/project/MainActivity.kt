package com.example.project
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
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
            val intent = Intent(this, emailSender::class.java)
            startActivity(intent)
        }

    }
}