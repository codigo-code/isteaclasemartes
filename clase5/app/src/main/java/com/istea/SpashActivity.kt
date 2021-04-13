package com.istea

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SpashActivity : AppCompatActivity() {

    private val TIME_OUT:Long=5000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spash)
        cargarSplash()
    }


    private fun cargarSplash(){
        Handler().postDelayed({
            // espera 5 seg antes de ejecutar es
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
            finish()
        },TIME_OUT)
    }
}