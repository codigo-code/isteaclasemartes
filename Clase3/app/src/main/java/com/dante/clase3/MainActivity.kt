package com.dante.clase3

import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.dante.clase3.model.Pelicula
import java.util.*
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // generamos la variable de tipo editText
        // buscamos en el layout activo ( ver linea 10) el id e_titulo y se lo asignamos a la variable titulo
        val titulo : EditText = findViewById(R.id.e_titulo)

        val genero : EditText = findViewById(R.id.e_genero)

        val url: EditText = findViewById(R.id.e_imageurl)





        val b: Button = findViewById(R.id.button)

        b.setOnClickListener(View.OnClickListener {
            // genero el objeto de tipo pelicula
            val peli = Pelicula(titulo.text.toString(),genero.text.toString(), url.text.toString())
            //Toast.makeText(this,peli.titulo +  "  " + peli.genero , Toast.LENGTH_LONG).show()

            // creamos un intento de llamar desde donde estamos parados a una nueva actividad
            // Intent(MainActivity y voy a ir a PeliculaActivity) ---> Intent(this, PeliculaActivity::class.java)
            val i: Intent = Intent(this, PeliculaActivity::class.java)

            i.putExtra("objectPeli",peli)



            startActivity(i)


        })

    }

    fun algo( peso: Double,  altura:Double):Any {

        if (peso < 18) {
            return R.mipmap.btf
        }
        return R.mipmap.btf
    }
}