package com.istea.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.istea.R
import com.istea.modelo.Helado

class HeladoAdapter(val dataSet:ArrayList<Helado>) : RecyclerView.Adapter<HeladoAdapter.ViewHolder>()
{
    // Vea el patron builder creacional

    // el mapping de los elementos que tengo el layout helado_item
    class ViewHolder(view:View):RecyclerView.ViewHolder(view){
        val descripcion: TextView
        val precio:TextView
        val foto:ImageView
        val comprar:Button

        // dentro del lifeCycle --> constrcutor --> init
        init {
            descripcion= view.findViewById(R.id.hi_desc)
            precio=view.findViewById(R.id.hi_precio)
            foto=view.findViewById(R.id.hi_foto)
            comprar=view.findViewById(R.id.hi_comprar)
        }
    }

    // damos de alta el layout de helado item
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        // ponemos en contexto el layout para ser utilizado en la inner class ViewHolder
       val view = LayoutInflater.from(parent.context).inflate(R.layout.helado_item,parent,false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.descripcion.text= "Descripcion: " + dataSet[position].descripcion
        holder.precio.text = "Precio:" + dataSet[position].precio.toString()
        holder.foto.setImageResource(dataSet[position].foto)
        holder.comprar.setOnClickListener(
            View.OnClickListener {
                Toast.makeText(it.context,dataSet[position].descripcion + " Agregado al carrito",Toast.LENGTH_LONG).show()
            }
        )
    }

}


