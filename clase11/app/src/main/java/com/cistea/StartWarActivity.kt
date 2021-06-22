package com.cistea

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.cistea.api.ApiStarWar
import com.cistea.api.ApiStarWarImplementation
import com.cistea.model.StartWar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

import java.lang.Exception
import kotlin.system.exitProcess

class StartWarActivity : AppCompatActivity() {

    lateinit var name: TextView
    lateinit var mass: TextView
    lateinit var height: TextView
    lateinit var hair_color: TextView
    lateinit var skin_color: TextView
    lateinit var birth_year: TextView
    lateinit var gennder: TextView
    lateinit var homeWolrd: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_war)


        initilize()

        val v : ApiStarWarImplementation = ApiStarWarImplementation()




        try {
            // inicializamos la conexion contra el api ( me va a traer el obj 3 )
            var api = ApiStarWar.create().getPersonaje()

            v.getPersona(2).enqueue(object : Callback<StartWar> {
            //api.enqueue(object : Callback<StartWar> {
                override fun onFailure(call: Call<StartWar>, t: Throwable) {
                    Toast.makeText(applicationContext,t.message,Toast.LENGTH_LONG).show()

                }

                override fun onResponse(call: Call<StartWar>, response: Response<StartWar>) {

                    // verifico que el objeto no venga vacio
                    if(response?.body() != null){
                        val data = response?.body()
                        name.text = data?.name.toString()
                        mass.text= data?.mass.toString()
                        height.text = data?.height.toString()
                        hair_color.text = data?.hair_color.toString()
                        skin_color.text = data?.skin_color.toString()
                        birth_year.text = data?.birth_year.toString()
                        gennder.text = data?.gender.toString()
                        homeWolrd.text = data?.homeworld.toString()
                    }
                }

            })




        }catch (e: Exception){
            Log.e("Error API",e.message,e )
        }


        val finalizar:Button = findViewById(R.id.sw_finalizar)

        finalizar.setOnClickListener(View.OnClickListener {
            moveTaskToBack(true);
            exitProcess(-1)
        })

    }


    private fun initilize(){


        name = findViewById(R.id.sw_name)
        mass = findViewById(R.id.sw_mass)
        height = findViewById(R.id.sw_heigh)
        hair_color = findViewById(R.id.sw_hair_color)
        skin_color = findViewById(R.id.sw_skin_color)
        birth_year = findViewById(R.id.sw_birth_year)
        gennder = findViewById(R.id.sw_gender)
        homeWolrd = findViewById(R.id.sw_homeworld)

    }



}
