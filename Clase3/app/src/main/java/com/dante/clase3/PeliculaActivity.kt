package com.dante.clase3

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import android.widget.VideoView
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


        // generamos un objeto de tipo pelicula y lo inicializamos con objeto que recibimos de la actividad anterior
        val peli : Pelicula = intent.getSerializableExtra("objectPeli") as Pelicula
        //null.algo = CABOOOM ---> exception

        titulo.text = peli.titulo
        genero.text = peli.genero
        //val ism: InputStream = java.net.URL(peli.url).openStream()
       // val bmp : Bitmap = BitmapFactory.decodeStream(ism)

       // imageURL.setImageBitmap(bmp)
        val imageURL: ImageView = findViewById(R.id.pi_imagen)

        val im = DownloadImageFromInternet(findViewById(R.id.pi_imagen)).execute(
            peli.url
        )

        val v : VideoView=findViewById(R.id.videoView)
        v.setVideoPath("http://videocdn.bodybuilding.com/video/mp4/62000/62792m.mp4")
        v.start()
        //imageURL.setImageResource(R.mipmap.btf)

    }

    private inner class DownloadImageFromInternet(var imageView: ImageView) : AsyncTask<String, Void, Bitmap?>() {
        init {
            Toast.makeText(applicationContext, "Please wait, it may take a few minute...",     Toast.LENGTH_SHORT).show()
        }
        override fun doInBackground(vararg urls: String): Bitmap? {
            val imageURL = urls[0]
            var image: Bitmap? = null
            try {
                val inp = java.net.URL(imageURL).openStream()
                image = BitmapFactory.decodeStream(inp)
            }
            catch (e: Exception) {
                Log.e("Error Message", e.message.toString())
                e.printStackTrace()
            }
            return image
        }
        override fun onPostExecute(result: Bitmap?) {
            imageView.setImageBitmap(result)
        }
    }
}