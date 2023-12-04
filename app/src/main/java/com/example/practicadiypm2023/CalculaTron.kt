package com.example.practicadiypm2023

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import java.util.Random

class CalculaTron : AppCompatActivity() {
    private var temporizador: CountDownTimer? = null
    private lateinit var temporizadorTextView:TextView
    private lateinit var operacionAzar: TextView
    private lateinit var operacionSiguiente:TextView
    private lateinit var operacionAntigua:TextView
    private lateinit var tutexta:TextView
    private lateinit var image:ImageView
    private lateinit var acertadasText:TextView
    private lateinit var falladasText:TextView

    var resop=0
    var num1=0
    var num2=0
    var resprox=0


    var res=""
    var contador=0
    var acertadas=0
    var falladas=0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calcula_tron)
        temporizadorTextView = findViewById(R.id.temporizador)
        operacionAntigua = findViewById(R.id.operacionAntigua2)
        tutexta=findViewById(R.id.tutexta)
        image=findViewById(R.id.imagenAciertoFallo)
        acertadasText=findViewById(R.id.acertadas)
        falladasText=findViewById(R.id.falladas)

        empezarTemporizador()

        operacionAzar = findViewById(R.id.operacionAzar)
        operacionSiguiente=findViewById(R.id.operacionSiguiente)
        generarOperacionSiguiente()

        val num1 = Random().nextInt(10)
        val num2 = Random().nextInt(10)

        resop=num1+num2
        val operacion = "$num1 + $num2"
        operacionAzar.text = operacion
    }
    fun botonNumero(view:View){
        when (view.id) {
            R.id.cero -> {
                res += "0"
                tutexta.text = res
            }

            R.id.uno -> {
                res += "1"
                tutexta.text = res
            }

            R.id.dos -> {
                res += "2"
                tutexta.text = res
            }

            R.id.tres -> {
                res += "3"
                tutexta.text = res
            }

            R.id.cuatro -> {
                res += "4"
                tutexta.text = res
            }

            R.id.cinco -> {
                res += "5"
                tutexta.text = res
            }

            R.id.seis -> {
                res += "6"
                tutexta.text = res
            }

            R.id.siete -> {
                res += "7"
                tutexta.text = res
            }

            R.id.ocho -> {
                res += "8"
                tutexta.text = res
            }

            R.id.nueve -> {
                res += "9"
                tutexta.text = res
            }

            R.id.c -> {
                if (res != "") {
                    res = res.substring(0, res.length - 1)
                }
                tutexta.text = res
            }

            R.id.ce -> {
                res = ""
                tutexta.text = res
            }

            R.id.igual -> {

                operacionAntigua.text = "${operacionAzar.text} = $res"
                operacionAzar.text = operacionSiguiente.text
                if (contador == 0) {
                    contador++
                    if (resop == res.toInt()) {
                        image.setImageResource(R.drawable.tickverde)
                        acertadas++
                        acertadasText.text = "Acertadas: $acertadas"
                    } else {
                        image.setImageResource(R.drawable.cruzroja)
                        falladas++
                        falladasText.text = "Falladas: $falladas"
                    }
                    generarOperacionSiguiente()
                    res = ""

                } else {
                  if (resprox == res.toInt()) {
                        image.setImageResource(R.drawable.tickverde)
                        acertadas++
                        acertadasText.text = "Acertadas: $acertadas"

                    } else {
                        image.setImageResource(R.drawable.cruzroja)
                        falladas++
                        falladasText.text = "Falladas: $falladas"
                    }
                    generarOperacionSiguiente()

                    res = ""
                }
            }
        }
    }
    private fun empezarTemporizador() {
        temporizador = object : CountDownTimer(45000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                temporizadorTextView.text = (millisUntilFinished / 1000).toString()
            }
            override fun onFinish() {
                temporizadorTextView.text = "Tiempo acabado"
                Handler().postDelayed({
                    recreate()
                },3000)
            }
        }
        temporizador?.start()
    }
     private fun generarOperacionSiguiente(){
         num1=Random().nextInt(10)
         num2=Random().nextInt(10)
         resprox=resop
         resop=num1+num2


         val operacion = "$num1 + $num2"

         operacionSiguiente.text=operacion

    }




























    fun animacion(view:View,tiempoX:Long,tiempoY:Long){
        view.animate().apply {
            scaleX(0.9f)
            scaleY(0.9f)
            duration=tiempoX
        }.withEndAction{
            view.animate().apply {
                scaleX(1.0f)
                scaleY(1.0f)
                duration=tiempoY
            }
        }
    }


    fun ajustes(view: View) {
        animacion(view,150,150)
    }
}