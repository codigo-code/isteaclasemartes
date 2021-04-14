package com.istea

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.Toast
import com.istea.model.User

class MainActivity : AppCompatActivity() {

    lateinit var user: EditText
    lateinit var pass: EditText
    lateinit var validar: Button
    lateinit var regsitrar: Button
    lateinit var f:FrameLayout
    //var userHardCode =User("admin","admin")
    lateinit var userModel:User
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inicilizarElementos()

        validar.setOnClickListener(

            View.OnClickListener {
                if(userValidation(user.text.toString(),pass.text.toString())){
                        gotToActity(this,InicioActitivy::class.java)
                }else{
                    Toast.makeText(this,"NO TIENE ACCESO POR FAVOR REGISTRESE", Toast.LENGTH_LONG).show()
                }
            }
        )


        regsitrar.setOnClickListener(
            View.OnClickListener {
                gotToActity(this,RegistrarActivity::class.java)
            }
        )


    }


    private fun <T>gotToActity(context:Context, activity:Class<T>){
        val i = Intent(context,activity)
        startActivity(i)
    }


    private fun userValidation(user:String, pass: String): Boolean{

        // seria lo mas cercano a un if ternario (condicion) ? verdadero : falso
        return userModel.name.equals(user)&& userModel.password.equals(pass)
    }

    // inicializo los elementos
    private fun inicilizarElementos(){
        user= findViewById(R.id.e_user)
        pass=findViewById(R.id.e_pass)
        validar=findViewById(R.id.b_validar)
        regsitrar=findViewById(R.id.b_registrar)
        f = findViewById(R.id.fragmentoMistico)
        // verifico que mi intent.getSerializableExtra ( donde viene el objeto de la actividad Registrar)
        // que no este nulo,
        // si es nulo uso los valores harcodeados ....
        // si viene cargo uso los que cree en mi actividad de registro

        if(intent.getSerializableExtra("userModel")  != null)
            userModel = intent.getSerializableExtra("userModel") as User // userModel = null
        else
            userModel=User("admin","admin")


        var vista : View = View(this)
        var inflate = LayoutInflater.from(this)
        var edit = inflate.inflate(R.layout.activity_main,null,false)as EditText
        edit.setText("caca")
    }
}