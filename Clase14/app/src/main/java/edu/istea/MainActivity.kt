package edu.istea

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import edu.istea.model.Helado
import edu.istea.view.HeladoFragment
import edu.istea.view.PublicidadFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val publicidad: PublicidadFragment = PublicidadFragment()
        val heladoView: HeladoFragment = HeladoFragment()

        // le indicamos que la app va a soportar fragmentos

        val manager = supportFragmentManager
        // inficamos a nuestra vista que se va a estar inyectando un fragmento
        val transaction = manager.beginTransaction()

        // remplazo un layout ( de cualquier tipo por un fragmento)
        transaction.replace(R.id.publicidad_frame,publicidad)


        // traigo la logica para el boton de helado y le paso un elemento Helado con  sus valores
        // logica para seleccionar el helado
        val heladoButton:Button= findViewById(R.id.helado)
        heladoButton.setOnClickListener(
            View.OnClickListener {
                val transactionHelado = manager.beginTransaction()
                // tenemos que pasarle los argumentos al fragmento

                val args = Bundle()
                args.putParcelable("helado",Helado("cono",R.mipmap.cono))
                heladoView.arguments = args
                transactionHelado.replace(R.id.comercio,heladoView)
                transactionHelado.commit()

            }
        )


        transaction.commit()




    }
}