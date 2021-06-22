package edu.istea.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import edu.istea.R

class PublicidadFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater!!.inflate(R.layout.publicidad_layout, container, false)

        // agregar los elementos del layout publicidad

        val imagen: ImageView = view.findViewById(R.id.pl_imagenPublicidad)
        val texto: TextView = view.findViewById(R.id.pl_textoPubilicidad)
        imagen.setImageResource(R.mipmap.kilo)
        //texto.setText("Aproveche la promo de junio!")

        return view

    }
}