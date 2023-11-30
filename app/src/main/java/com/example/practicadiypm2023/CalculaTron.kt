package com.example.practicadiypm2023

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.TextView

class CalculaTron : AppCompatActivity() {
    private var temporizador: CountDownTimer? = null
    private lateinit var temporizadorTextView:TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calcula_tron)
        temporizadorTextView = findViewById<TextView>(R.id.temporizador)

        empezarTemporizador()
    }

    private fun empezarTemporizador() {
        temporizador = object : CountDownTimer(45000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                temporizadorTextView.text = (millisUntilFinished / 1000).toString()
            }

            override fun onFinish() {
                temporizadorTextView.text = "El tiempo ha terminado"
                recreate()
            }
        }

        temporizador?.start()
    }
}