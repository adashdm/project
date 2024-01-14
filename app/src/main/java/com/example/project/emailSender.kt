package com.example.project
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


class emailSender : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_email_sender)
        val sendButton: Button = findViewById(R.id.button)
        sendButton.setOnClickListener {
            val emailEditText = findViewById<EditText>(R.id.editTextTextEmailAddress2)
            val textMessageEditText = findViewById<EditText>(R.id.editTextTextMultiLine2)
            val recipientEmail = emailEditText.text.toString()
            val textMessage = textMessageEditText.text.toString()
            if (recipientEmail.isNotEmpty() && textMessage.isNotEmpty()) {
                sendEmail(recipientEmail, textMessage)
                finish()
            }
            else Toast.makeText(this, "Заповніть поля!", Toast.LENGTH_SHORT).show()
        }
    }
    private fun sendEmail(recipientEmail : String, textMessage : String) {
        val uriText = "mailto:$recipientEmail" +
                "?subject=" + Uri.encode("Subject") +
                "&body=" + Uri.encode(textMessage)

        val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse(uriText)
        }
        startActivity(Intent.createChooser(emailIntent, "Send feedback"))
    }
}