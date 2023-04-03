package com.example.relojalarma

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextClock
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var horaPrincipal: TextClock

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        horaPrincipal = findViewById(R.id.idhora_principal)
        horaPrincipal.format12Hour = "HH:mm:ss a"


        /* DE LA SIG FORMA PODEMOS AGREGAR NUESTRAS FUNCIONES A NUESTROS BOTONES
        val btnColor : Button = findViewById(R.id.btn_color)
        val txtPrincipal : TextView = findViewById(R.id.idtext_principal)

        btnColor.setOnClickListener{
            txtPrincipal.setTextColor(android.graphics.Color.MAGENTA)
        }
        */

    }

    fun cambiarColor(view: View){
        val txtPrincipal : TextView = findViewById(R.id.idtext_principal)
        txtPrincipal.setTextColor(android.graphics.Color.GREEN)

        Toast.makeText(applicationContext, "Cambio de color Exitoso", Toast.LENGTH_LONG).show()
    }

    fun menuNavigation(view: View) {
        val intent = Intent(this, ActivityAlarm::class.java)
        startActivity(intent)
    }
}