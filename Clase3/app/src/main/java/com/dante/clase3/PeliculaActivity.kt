package com.dante.clase3

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.dante.clase3.model.Pelicula
import java.io.InputStream
import java.net.URL


class PeliculaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pelicula)

        val titulo: TextView = findViewById(R.id.pe_titulo)
        val genero: TextView = findViewById(R.id.pe_genero)
        val imageURL: ImageView = findViewById(R.id.pi_imagen)

        // generamos un objeto de tipo pelicula y lo inicializamos con objeto que recibimos de la actividad anterior
        val peli : Pelicula = intent.getSerializableExtra("objectPeli") as Pelicula
        //null.algo = CABOOOM ---> exception

        titulo.text = peli.titulo
        genero.text = peli.genero
       // val ism: InputStream = URL(peli.url).openStream()
       // val bmp : Bitmap = BitmapFactory.decodeStream(ism)

       // imageURL.setImageBitmap(bmp)

        imageURL.setImageResource(R.mipmap.btf)

    }
}