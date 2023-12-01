package com.example.practicadiypm2023

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.widget.TextView
import java.util.Random

class CalculaTron : AppCompatActivity() {
    private var temporizador: CountDownTimer? = null
    private lateinit var temporizadorTextView:TextView
    private lateinit var operacionAzar: TextView
    private lateinit var operacionSiguiente:TextView
    private lateinit var operacionAntigua:TextView
    private var igualPulsado = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calcula_tron)
        temporizadorTextView = findViewById(R.id.temporizador)
        operacionAntigua = findViewById(R.id.operacionAntigua2)

        empezarTemporizador()

        operacionAzar = findViewById(R.id.operacionAzar)
        operacionSiguiente=findViewById(R.id.operacionSiguiente)

        generarSuma()
        generarOperacionSiguiente()
        operacionAntigua()
    }

    private fun empezarTemporizador() {
        temporizador = object : CountDownTimer(45000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                temporizadorTextView.text = (millisUntilFinished / 1000).toString()

            }
            override fun onFinish() {
                temporizadorTextView.text = "El tiempo ha terminado"
                Handler().postDelayed({
                    recreate()
                },3000)
            }
        }

        temporizador?.start()

    }


    private fun generarSuma() {

        val random = Random()
        val num1 = random.nextInt(10)
        val num2 = random.nextInt(10)

        val operacion = "$num1 + $num2"
        operacionAzar.text = operacion
    }

    private fun generarOperacionSiguiente(){
        val random = Random()
        val num1=random.nextInt(10)
        val num2=random.nextInt(10)
        val operacion = "$num1 + $num2"
        operacionSiguiente.text=operacion
    }

    private fun operacionAntigua(){
        operacionAntigua.text=operacionAzar.text
    }
}