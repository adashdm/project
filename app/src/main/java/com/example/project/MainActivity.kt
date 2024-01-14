package com.example.project
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import android.Manifest
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    private val CALL_PERMISSION_REQUEST_CODE = 8789
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val pButton: Button = findViewById(R.id.bPhone)
        val eButton: Button = findViewById(R.id.bEmail)
        val number = "23454568678"
        pButton.setOnClickListener {
            if (isCallPermissionGranted()) {
                callNumber(number)
            } else {
                requestCallPermission()
            }
        }
        eButton.setOnClickListener {
            val intent = Intent(this, emailSender::class.java)
            startActivity(intent)
        }
    }

    private fun callNumber(number : String)  {
        val intent = Intent(Intent.ACTION_CALL)
        intent.data = Uri.parse("tel:$number")
        startActivity(intent)
    }

    private fun isCallPermissionGranted(): Boolean {
        return ContextCompat.checkSelfPermission(
            this,
            Manifest.permission.CALL_PHONE
        ) == PackageManager.PERMISSION_GRANTED
    }

    private fun requestCallPermission() {
        ActivityCompat.requestPermissions(
            this,
            arrayOf(Manifest.permission.CALL_PHONE),
            CALL_PERMISSION_REQUEST_CODE
        )
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode == CALL_PERMISSION_REQUEST_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            } else {
                Toast.makeText(this, "No call permission!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}