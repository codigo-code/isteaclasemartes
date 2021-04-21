package com.istea.clase6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.istea.clase6.modelo.User

class MainActivity : AppCompatActivity() {

    lateinit var email: EditText
    lateinit var pass: EditText
    lateinit var nombre:EditText
    lateinit var fechaNacimiento:EditText
    lateinit var fuma: Switch
    lateinit var opcionId: RadioGroup
    lateinit var opcionSeleccionada : RadioButton
    lateinit var user: User
    lateinit var aceptar : Button
    lateinit var ver_usuario:Button


     var listaUsuerios: ArrayList<User> = ArrayList<User>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inicializarElementos()

        val profesionList = arrayOf("estudiante","profesor","administrativo")

        var adapter = ArrayAdapter(this,android.R.layout.simple_spinner_item,profesionList)

        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)

        val sp:Spinner = findViewById(R.id.s_profesion)

        sp.adapter=adapter
        var txtSeleccionado : String =""
        sp.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                // Display the selected item text on text view
                txtSeleccionado = parent.getItemAtPosition(position).toString()
            }
        }

        aceptar.setOnClickListener(View.OnClickListener {
            opcionId=findViewById(R.id.r_opcion_sexo)
            opcionSeleccionada =findViewById(opcionId.checkedRadioButtonId)

            user = User(email.text.toString(),pass.text.toString(),nombre.text.toString(),fuma.isChecked,opcionSeleccionada.text.toString(),txtSeleccionado)
            // a mi lista de usuarios le agrego un usuario que cargue desde la aplicacion
            listaUsuerios.add(user)
            limpiarCampos()

            Toast.makeText(this,"El usuario ha sido guardado!", Toast.LENGTH_LONG).show()
        })



        ver_usuario.setOnClickListener(
            View.OnClickListener {
                var intent = Intent(this, MuestroUsuarioActivity::class.java)
                intent.putExtra("listaUsuarios",listaUsuerios)
                if(!listaUsuerios.isEmpty())
                    startActivity(intent)
                else
                    Toast.makeText(this,"La lista esta vacia y no se puede llamar a la actividad", Toast.LENGTH_LONG).show()
            }
        )
    }

    private fun inicializarElementos() {
        email=findViewById(R.id.e_mail)
        pass=findViewById(R.id.e_password)
        fechaNacimiento=findViewById(R.id.e_fechanacimiento)
        fuma=findViewById(R.id.s_fuma)

        nombre=findViewById(R.id.e_nombre)
        aceptar=findViewById(R.id.b_aceptar)
        ver_usuario=findViewById(R.id.b_ver_usuarios)

    }

    private fun limpiarCampos(){
        email.setText("")
        pass.setText("")
        fechaNacimiento.setText("")
        nombre.setText("")
        fuma.isChecked=false
    }


}