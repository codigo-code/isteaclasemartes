package com.cistea

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import com.facebook.stetho.Stetho
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Stetho.initializeWithDefaults(this);


        val img: ImageView = findViewById(R.id.imageView)
        img.setImageResource(R.mipmap.flaco)


        val fb: FloatingActionButton= findViewById(R.id.fb_button)

        fb.setImageResource(R.mipmap.cono)
        fb.setOnClickListener(View.OnClickListener {

            val intent: Intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
        })


        val bfapi:FloatingActionButton = findViewById(R.id.bf_api)

        bfapi.setOnClickListener(View.OnClickListener {

            var intent : Intent= Intent(this, StartWarActivity::class.java)
            startActivity(intent)
        })

    }
}