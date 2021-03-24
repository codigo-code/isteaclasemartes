package com.dante.clase2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // definir la variable ,darle un nombre, decir de que tipo es , y ubicarla dentro de mi layhout

        // acabamos de vincular el elemento de la vista contra nuestra variable en kotlin
        val nombre : EditText = findViewById(R.id.e_nombre)

        // todo_ esta relacionado con eventos
        // kotlin val nombre: tipo = valor ---> val nombre : String = "dante" - val edad: Int =38
        val boton : Button = findViewById(R.id.b_press)

        // vinculamos el header
        val header : TextView = findViewById(R.id.t_header)

        // handle ---> manejador de eventos al presionar el boton
        boton.setOnClickListener(View.OnClickListener {
            // internamente hace un header.setText(nombre.getText());
            header.text = "Hola " +  nombre.text + ", como estas?"
        })

    }
}