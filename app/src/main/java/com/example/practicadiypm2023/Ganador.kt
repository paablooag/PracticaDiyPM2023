package com.example.practicadiypm2023

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Ganador : AppCompatActivity() {
    var mediaPlayer:MediaPlayer?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ganador)


        mediaPlayer=MediaPlayer.create(this,R.raw.ibai)
        mediaPlayer?.start()
    }
    fun Reiniciar(view: View) {

        mediaPlayer?.stop()
        val intent= Intent(this, Juego::class.java)
        startActivity(intent)
    }
}