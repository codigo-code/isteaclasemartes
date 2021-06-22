package edu.istea.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import edu.istea.R

class CajeroFragment: Fragment(){



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater!!.inflate(R.layout.cajero_layout, container, false)

        // agregar los elementos del layout publicidad

        val texto: TextView = view.findViewById(R.id.cl_textcajero)
        texto.setText("Lo atiende Mengano!")

        return view

    }
}