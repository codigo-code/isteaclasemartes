package com.istea

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.LinearLayout.VERTICAL
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.istea.adapter.HeladoAdapter
import com.istea.modelo.Helado

class MainActivity : AppCompatActivity() {

    val listaHelado:ArrayList<Helado> = ArrayList<Helado>()
    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        cargoHelados()

        // levantar el recycleView que tenemos en nuestra vista activity_main.xml
        val recycleViewHelado:RecyclerView = findViewById(R.id.recycleListHelados)

        //
        recycleViewHelado.layoutManager = LinearLayoutManager(this, VERTICAL,false)

        val adapterHelado = HeladoAdapter(listaHelado)

        recycleViewHelado.adapter=adapterHelado

    }


    private  fun cargoHelados(){
        listaHelado.add(Helado("cono",100,R.mipmap.cono))
        listaHelado.add(Helado("cuarto",350,R.mipmap.cuarto))
        listaHelado.add(Helado("kilo",750,R.mipmap.kilo))
    }
}