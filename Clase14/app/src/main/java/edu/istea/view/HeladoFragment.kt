package edu.istea.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import edu.istea.MainActivity
import edu.istea.R
import edu.istea.model.Helado

class HeladoFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater!!.inflate(R.layout.helado_layout, container, false)

        // estamos recibiendo los argumentos que "supuestamente cargaron en el main activity"
        val args= arguments



        val texto: TextView = view.findViewById(R.id.hl_tipoHelado)
        val foto:ImageView = view.findViewById(R.id.hl_foto)


        val hs: Helado? = args?.getParcelable<Helado>("helado")
        texto.setText(hs?.nombre)
        if (hs != null) {
            foto.setImageResource(hs.foto)
        }




        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val pedir:Button = view.findViewById(R.id.hl_pedir)
        val args = arguments
        val hs: Helado? = args?.getParcelable<Helado>("helado")
        // logica X para pedir el helado!
        pedir.setOnClickListener(
            View.OnClickListener {
               // Toast.makeText(view.context,"helado selecionado",Toast.LENGTH_LONG).show()

                // trabajo con la navegacion

                // me creo el objeto navegacion

                val accion = HeladoFragmentDirections.actionHeladeriaToCajero()

               // accion.arguments.putParcelable("heladoSeleccionado",hs)

                Navigation.findNavController(view).navigate(accion)

            }
        )



    }
}