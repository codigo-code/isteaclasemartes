package com.istea

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var bJuan:Button
    lateinit var bPedro:Button
    lateinit var bactividad:Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        bJuan=findViewById(R.id.b_juan)
        bPedro=findViewById(R.id.b_pedro)
        val muestroLayout:LinearLayout = findViewById(R.id.muestroLayout)
        val algo:TextView= TextView(this)
        algo.setText("hola mundo")


        bJuan.setOnClickListener(
                View.OnClickListener {
                    var view = LayoutInflater.from(this).inflate(R.layout.activity_doc_juan,null)
                    muestroLayout.removeAllViews()
                    muestroLayout.addView(view)
                }
        )

        bPedro.setOnClickListener(
            View.OnClickListener {
                var view = LayoutInflater.from(this).inflate(R.layout.activity_doc_pedro,null)
                var boton:Button = view.findViewById(R.id.b_pedro_magia)
                muestroLayout.removeAllViews()
                muestroLayout.addView(view)
                bJuan.isEnabled=false

                boton.setOnClickListener(
                    View.OnClickListener {
                        bJuan.isEnabled=true // cuando cierro la vista volver a habilitarlo
                    }
                )
            }

        )

        bactividad = findViewById(R.id.button3)
        bactividad.setOnClickListener(
                View.OnClickListener {
                    startActivity(Intent(this,CajeroActivity::class.java))
                }
        )

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