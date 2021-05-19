package com.istea

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.istea.dao.DBHelper
import com.istea.dto.Persona

class MainActivity : AppCompatActivity() {

    lateinit var nombre: EditText
    lateinit var dni: EditText
    lateinit var guardar: Button
    lateinit var ver:Button
    lateinit var persona_layout:LinearLayout




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nombre= findViewById(R.id.nombre)
        dni = findViewById(R.id.dni)
        guardar = findViewById(R.id.guardar)
        val db = DBHelper(this,null)
        ver = findViewById(R.id.verPersonas)
        persona_layout= findViewById(R.id.personalaout)
        guardar.setOnClickListener(View.OnClickListener {



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



        ver.setOnClickListener(View.OnClickListener {

            var view = LayoutInflater.from(this).inflate(R.layout.persona_layout,null)

            val nombre:TextView = view.findViewById(R.id.tx_nombre)
            val dni :TextView = view.findViewById(R.id.tx_dni)

            db.obtenerPersonas().forEach{item ->
                nombre.text=item.nombre
                dni.text=item.dni
            }

            persona_layout.removeAllViews()
            persona_layout.addView(view)
        })
    }
}