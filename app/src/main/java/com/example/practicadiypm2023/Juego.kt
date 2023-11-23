package com.example.practicadiypm2023

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import kotlin.concurrent.timer
import kotlin.random.Random

class Juego : AppCompatActivity() {
    private lateinit var imagenes:MutableList<Int>
    private lateinit var booleanos:MutableList<Boolean>
    private lateinit var comparar:MutableList<Boolean>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_juego)
        imagenes = mutableListOf(R.drawable.hombrebetis, R.drawable.hombreplay, R.drawable.hombreculturista
                                    ,R.drawable.mujerdurmiendo, R.drawable.mujervenus, R.drawable.mujerpelirroja,
                                     R.drawable.hombrebetis, R.drawable.hombreplay, R.drawable.hombreculturista
                                    ,R.drawable.mujerdurmiendo, R.drawable.mujervenus, R.drawable.mujerpelirroja)

        booleanos = mutableListOf(false, false, false, false, false, false, false, false, false, false, false, false)
        comparar = mutableListOf(false, false, false, false, false, false, false, false, false, false, false, false)
    }

    fun cartaPulsada(view: View) {
        var imagenesnuevas=imagenes.random()

        when(view.id){
            R.id.carta1->{
                var cartanueva1 = findViewById<ImageView>(R.id.carta1)
                if(!booleanos[0]){
                    cartanueva1.setImageResource(imagenesnuevas)
                    imagenes.remove(imagenesnuevas)
                    booleanos[0]=true
                 }
            }
            R.id.carta2->{
                var cartanueva1 = findViewById<ImageView>(R.id.carta2)
                if(!booleanos[1]){
                    cartanueva1.setImageResource(imagenesnuevas)
                    imagenes.remove(imagenesnuevas)
                    booleanos[1]=true
                 }
            }
            R.id.carta3->{
                var cartanueva1 = findViewById<ImageView>(R.id.carta3)
                if(!booleanos[2]){
                    cartanueva1.setImageResource(imagenesnuevas)
                    imagenes.remove(imagenesnuevas)

                    booleanos[2]=true
                 }
            }
            R.id.carta4->{
                var cartanueva1 = findViewById<ImageView>(R.id.carta4)
                if(!booleanos[3]){
                    cartanueva1.setImageResource(imagenesnuevas)
                    imagenes.remove(imagenesnuevas)
                    booleanos[3]=true
                }
            }
            R.id.carta5->{
                var cartanueva1 = findViewById<ImageView>(R.id.carta5)
                if(!booleanos[4]){
                    cartanueva1.setImageResource(imagenesnuevas)
                    imagenes.remove(imagenesnuevas)
                    booleanos[4]=true
                }
            }
            R.id.carta6->{
                var cartanueva1 = findViewById<ImageView>(R.id.carta6)
                if(!booleanos[5]){
                    cartanueva1.setImageResource(imagenesnuevas)
                    imagenes.remove(imagenesnuevas)
                    booleanos[5]=true
                }
            }
            R.id.carta7->{
                var cartanueva1 = findViewById<ImageView>(R.id.carta7)
                if(!booleanos[6]){
                    cartanueva1.setImageResource(imagenesnuevas)
                    imagenes.remove(imagenesnuevas)
                    booleanos[6]=true
            }
        }
            R.id.carta8->{
                var cartanueva1 = findViewById<ImageView>(R.id.carta8)
                if(!booleanos[7]){
                    cartanueva1.setImageResource(imagenesnuevas)
                    imagenes.remove(imagenesnuevas)
                    booleanos[7]=true
                }
            }
            R.id.carta9->{
                var cartanueva1 = findViewById<ImageView>(R.id.carta9)
                if(!booleanos[8]){
                    cartanueva1.setImageResource(imagenesnuevas)
                    imagenes.remove(imagenesnuevas)
                    booleanos[8]=true
                }
            }
            R.id.carta10->{
                var cartanueva1 = findViewById<ImageView>(R.id.carta10)
                if(!booleanos[9]){
                    cartanueva1.setImageResource(imagenesnuevas)
                    imagenes.remove(imagenesnuevas)
                    booleanos[9]=true
                }
            }
            R.id.carta11->{
                var cartanueva1 = findViewById<ImageView>(R.id.carta11)
                if(!booleanos[10]){
                    cartanueva1.setImageResource(imagenesnuevas)
                    imagenes.remove(imagenesnuevas)
                    booleanos[10]=true
                }
            }
            R.id.carta12->{
                var cartanueva1 = findViewById<ImageView>(R.id.carta12)
                if(!booleanos[11]){
                    cartanueva1.setImageResource(imagenesnuevas)
                    imagenes.remove(imagenesnuevas)
                    booleanos[11]=true
                }
            }
        }
    }


    fun Reiniciar(view: View) {
        recreate()
    }
}
