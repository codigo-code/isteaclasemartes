package com.istea

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.istea.model.User

class RegistrarActivity : AppCompatActivity() {
    lateinit var user: EditText
    lateinit var pass: EditText
    lateinit var repass:EditText
    lateinit var ok:Button
    lateinit var clean:Button
    lateinit var error:TextView
    lateinit var userModel:User
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar)
        initialization()

        clean.setOnClickListener(
                View.OnClickListener {
                    cleanElements()
                }
        )

        ok.setOnClickListener(View.OnClickListener {
            if(pass.text.toString().equals(repass.text.toString())){
                // la condicion es verdadera y vamos a poder guardar el usuario
                userModel = User(user.text.toString(),pass.text.toString())
                val i = Intent(this,MainActivity::class.java)
                i.putExtra("userModel",userModel)
                startActivity(i)
            }else{
                error.setText("El password no es correcto por favor validarlo! ")
            }
        })

    }

    private fun cleanElements(){
        user.setText("")
        pass.setText("")
        repass.setText("")
    }

    private fun initialization(){
        user=findViewById(R.id.r_e_user)
        pass=findViewById(R.id.r_e_pass)
        repass=findViewById(R.id.r_e_repass)
        ok=findViewById(R.id.r_b_ok)
        clean=findViewById(R.id.r_b_clean)
        error=findViewById(R.id.r_t_mensajeError)


    }
}