package com.istea

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.istea.dao.DBHelper
import com.istea.dto.Persona

class MainActivity : AppCompatActivity() {

    lateinit var nombre: EditText
    lateinit var dni: EditText
    lateinit var guardar: Button

    init {
        nombre= findViewById(R.id.nombre)
        dni = findViewById(R.id.dni)
        guardar = findViewById(R.id.guardar)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        guardar.setOnClickListener(View.OnClickListener {

            val db = DBHelper(this,null)

            // antes de guardar llamos al AlertDialog

            var builder = AlertDialog.Builder(this)

            builder.setTitle("Desea guardar la persona?")
            builder.setMessage("Se estara guardando en la base llamda persona.db")
            builder.setPositiveButton("Guardar"){dialogInterface, i ->
                db.guardarPersona(Persona(nombre.text.toString(),dni.text.toString()))
                Toast.makeText(it.context, "Persona guardada correctamente", Toast.LENGTH_LONG).show()
            }

            builder.setNegativeButton("No quiero!!!!"){ dialogInterface, i ->
                Toast.makeText(it.context, "No lo ha guardado!!", Toast.LENGTH_SHORT).show()
            }


            val alerta : AlertDialog = builder.create()
            alerta.show()



        })
    }
}