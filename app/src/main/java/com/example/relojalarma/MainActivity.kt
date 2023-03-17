package com.example.relojalarma

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextClock

class MainActivity : AppCompatActivity() {

    lateinit var clockTC: TextClock

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        clockTC = findViewById(R.id.idTCClock)
        clockTC.format12Hour = "HH:mm:ss a"
    }
}