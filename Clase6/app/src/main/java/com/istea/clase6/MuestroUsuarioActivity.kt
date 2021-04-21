package com.istea.clase6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.istea.clase6.modelo.User
import java.lang.Exception

class MuestroUsuarioActivity : AppCompatActivity() {

    lateinit var idElemento : EditText
    lateinit var buscar:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_muestro_usuario)

        inicializar()

        buscar.setOnClickListener(
            View.OnClickListener {

                // aqui vamos a recuperar la lista que cargamos previamente y la mostraremos en una tostada
                try {
                    val lista = intent.getSerializableExtra("listaUsuarios") as ArrayList<User>
                    val u : User = lista.get(idElemento.text.toString().toInt())
                    Toast.makeText(this,u.nombre + " " + u.sexo, Toast.LENGTH_LONG).show()
                    Log.i("nombre", u.nombre)
                    Log.i("email", u.email)
                    Log.i("sexo", u.sexo)
                    Log.i("fuma", u.fuma.toString())
                    Log.i("profesion", u.profesion)
                }catch (e: Exception){
                    Toast.makeText(this, "no existe el id en la lista",Toast.LENGTH_LONG).show()
                }



            }


        )

    }


    private fun inicializar(){
        idElemento = findViewById(R.id.mu_id)
        buscar = findViewById(R.id.mu_buscar)
    }
}