package edu.istea.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import edu.istea.R

class ProductoFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.producto_layout,container,false)




        return view
    }


    // una vez que se inicializo el fragmento mapeo el boton y utilizo la navegacion para moverme
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val b: Button = view.findViewById(R.id.p_button)

        b.setOnClickListener(

            View.OnClickListener {

               val action =  ProductoFragmentDirections.actionProductoFragmentToItemFragment()

                Navigation.findNavController(it).navigate(action)
            }
        )
    }
}