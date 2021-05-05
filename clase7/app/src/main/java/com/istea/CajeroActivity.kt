package com.istea

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*

class CajeroActivity : AppCompatActivity() {

    // forma cochineira :P
    val lista: ArrayList<String> = ArrayList<String>() // <--- esto debe ser un obj
    lateinit var bsuma:Button
    lateinit var rgroup:RadioGroup
    lateinit var opcion:RadioButton
    lateinit var contCaja1:TextView
    lateinit var contCaja2:TextView
    lateinit var mostrar_caja:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cajero)


        bsuma=findViewById(R.id.b_suma)
        contCaja1=findViewById(R.id.t_contadorCaja1)
        contCaja2=findViewById(R.id.t_contadorCaja2)
        mostrar_caja=findViewById(R.id.b_mostrar_caja)

        rgroup=findViewById(R.id.rc_grupo)

        bsuma.setOnClickListener(View.OnClickListener {

            opcion =findViewById(rgroup.checkedRadioButtonId)

            when(opcion.text){
               "caja1"->{
                   if(contCaja1.text.toString().toInt() < 3){
                       lista.add("caja1")
                       contCaja1.text= (contCaja1.text.toString().toInt() + 1).toString()
                   }else{
                       Toast.makeText(this,"Caja 1 desabilitada",Toast.LENGTH_LONG).show()
                       opcion.isEnabled=false
                   }

                }
                "caja2"->{
                    lista.add("caja2")
                    contCaja2.text= (contCaja2.text.toString().toInt() + 1).toString()

                }
            }
        })


        mostrar_caja.setOnClickListener(View.OnClickListener {
            var view = LayoutInflater.from(this).inflate(R.layout.muestro_cajeros_atendidos,null)

            var text:TextView =  view.findViewById(R.id.t_caja_atendida)


            opcion =findViewById(rgroup.checkedRadioButtonId)

            when(opcion.text){
                "caja1"->{
                    // cochinada x 2000
                    for(item in lista){
                        if(item.equals("caja1")){
                            text.text = text.text.toString() + "\n"+ item
                        }
                    }
                }
            }

            var inyectoLayout:LinearLayout=findViewById(R.id.layout_caja)
            inyectoLayout.removeAllViews()
            inyectoLayout.addView(view)
        })
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.mi_menu,menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when(item.itemId){
            R.id.menu_cajero->{
                startActivity(Intent(applicationContext,CajeroActivity::class.java))
                true
            }R.id.menu_main->{
                startActivity(Intent(applicationContext,MainActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}