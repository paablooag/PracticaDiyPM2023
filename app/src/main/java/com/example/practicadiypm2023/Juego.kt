package com.example.practicadiypm2023

import android.graphics.drawable.Drawable
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.AutoCompleteTextView
import android.widget.ImageView
import android.widget.TextView
import kotlin.concurrent.thread
import kotlin.concurrent.timer
import kotlin.random.Random

class Juego : AppCompatActivity() {
    private lateinit var imagenes:MutableList<Int>
    private lateinit var booleanos:MutableList<Boolean>

    var contadorGanar = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_juego)
        imagenes = mutableListOf(R.drawable.hombrebetis, R.drawable.hombreplay, R.drawable.hombreculturista
                                    ,R.drawable.mujerdurmiendo, R.drawable.mujervenus, R.drawable.mujerpelirroja,
                                     R.drawable.hombrebetis, R.drawable.hombreplay, R.drawable.hombreculturista
                                    ,R.drawable.mujerdurmiendo, R.drawable.mujervenus, R.drawable.mujerpelirroja)

        booleanos = mutableListOf<Boolean>(false, false, false, false, false, false, false, false, false, false, false, false)
        imagenes.shuffle()


    }
    lateinit var cartaActual:ImageView
    lateinit var cartaAnterior:ImageView
    var posicionAnterior:Int? = null
    var contador = 0

    fun cartaPulsada(view: View) {
        if (::cartaActual.isInitialized) {
            cartaAnterior = cartaActual
        }
        cartaActual = view as ImageView

        val posicion = when (view.id) {
            R.id.carta1 -> 0
            R.id.carta2 -> 1
            R.id.carta3 -> 2
            R.id.carta4 -> 3
            R.id.carta5 -> 4
            R.id.carta6 -> 5
            R.id.carta7 -> 6
            R.id.carta8 -> 7
            R.id.carta9 -> 8
            R.id.carta10 -> 9
            R.id.carta11 -> 10
            R.id.carta12 -> 11
            else -> -1
        }

        if (!booleanos[posicion]) {
            contador++
            val cartanueva1 = view.findViewById<ImageView>(view.id)

            cartanueva1.setImageResource(imagenes[posicion])
            cartanueva1.tag = imagenes[posicion].toString()

            booleanos[posicion] = true
        }

        if (::cartaAnterior.isInitialized && contador == 2) {
            compararCartas(cartaAnterior, cartaActual, posicion, posicionAnterior!!)
        } else {
            posicionAnterior = posicion
        }
    }
    private fun compararCartas(cartaAnterior: ImageView, cartaActual: ImageView, posicion:Int, posicionAnterior:Int) {
        val idAnterior = cartaAnterior.tag
        val idActual = cartaActual.tag
        var posicion = posicion
        var posicionAnterior = posicionAnterior

        if (idAnterior != idActual && contador==2) {
            cartaAnterior.postDelayed({
                cartaAnterior.setImageResource(R.drawable.parteatras)
                cartaActual.setImageResource(R.drawable.parteatras)
                booleanos[posicion]=false
                booleanos[posicionAnterior]=false
                contador=0
            }, 500)
        }else if(contador==2){
            booleanos[posicion]=true
            booleanos[posicionAnterior]=true
            cartaAnterior.tag=null
            contador=0
            posicionAnterior=0
            contadorGanar++
            if(contadorGanar==6){
                var texto = findViewById<TextView>(R.id.textGanar)
                texto.setText("Has ganado campeón")
            }
        }
    }


    fun Reiniciar(view: View) {
        recreate()
    }
}
