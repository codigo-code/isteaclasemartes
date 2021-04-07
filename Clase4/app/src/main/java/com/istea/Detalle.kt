package com.istea

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.istea.model.Persona
import net.objecthunter.exp4j.ExpressionBuilder

class Detalle : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle)
        val persona : Persona = intent.getSerializableExtra("persona") as Persona

        // enlazar los elementos
        val detalle : TextView = findViewById(R.id.t_detalle)
        val peso: TextView = findViewById(R.id.t_peso)
        val altura: TextView = findViewById(R.id.t_altura)
        val calcularIMC: TextView = findViewById(R.id.e_calculoimc)
        val b_uno : Button = findViewById(R.id.b_1)
        val b_dos : Button = findViewById(R.id.b_dos)
        val b_tres : Button = findViewById(R.id.b_tres)
        val b_mas : Button = findViewById(R.id.b_mas)
        val b_igual : Button = findViewById(R.id.b_igual)
        val b_borrar:Button= findViewById(R.id.b_borrar)




        detalle.text = persona.detalle
        peso.text=persona.peso.toString() // convierto mi numero en un string
        altura.text= persona.altura.toString()


        b_uno.setOnClickListener(View.OnClickListener {
            calcularIMC.text=calcularIMC.text.toString() + "1"
        })

        b_dos.setOnClickListener(
            View.OnClickListener {
                calcularIMC.text=calcularIMC.text.toString()+"2"
            }
        )

        b_mas.setOnClickListener(View.OnClickListener {
            calcularIMC.text=calcularIMC.text.toString()+"+"
        })

        b_igual.setOnClickListener(View.OnClickListener {
            // ExpressBuilder lo obtenemos de nuestra libreria Exp4j ( nos sirve para expresiones arimeticas)
            // espera un string -> ejemplo " 1+2+1 /2" ---> toma los simbolos como operadores y efectua el calculo
            val calculo =  ExpressionBuilder(calcularIMC.text.toString()).build()
            // la ejecucion con el evaluate() ---> lo convertimos en string -> y lo mandamos al texto nuevamente
            calcularIMC.text = calculo.evaluate().toString()
        })

        b_borrar.setOnClickListener(
            View.OnClickListener {
                calcularIMC.text=""
            }
        )






    }
}