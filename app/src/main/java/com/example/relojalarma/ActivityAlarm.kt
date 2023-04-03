package com.example.relojalarma

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast

class ActivityAlarm : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alarm)

        R.id.idtime_picker
    }

    fun agregarAlarma(view: View){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)

        Toast.makeText(applicationContext, "Alarma Agregada", Toast.LENGTH_LONG).show()
    }

}