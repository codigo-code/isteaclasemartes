package com.dante.clase2

import android.content.BroadcastReceiver
import android.content.Intent
import android.content.IntentFilter
import android.net.wifi.WifiManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.dante.clase2.aervices.BroadCast

class MainActivity : AppCompatActivity() {


    var reciver : BroadcastReceiver?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        reciver = BroadCast()
        var filter = IntentFilter(WifiManager.WIFI_STATE_CHANGED_ACTION)
        registerReceiver(reciver,filter)


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
            val i :Intent = Intent(this, PersonaActivity::class.java)
            startActivity(i)
        })

    }
}