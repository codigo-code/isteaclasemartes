package com.istea

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.wifi.WifiManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.istea.model.Persona
import com.istea.service.BroadCast

class MainActivity : AppCompatActivity() {


    // que no se generen multiples instancias del objeto Persona

    var persona=Persona(0.0,0.0,"")
    lateinit var wifiSwitch: Switch
    lateinit var wifiManager: WifiManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // enzalo los elementos
        val peso : EditText = findViewById(R.id.e_peso)
        val altura : EditText = findViewById(R.id.e_altura)
        val calcular : Button = findViewById(R.id.b_calcular)
        val foto: ImageView = findViewById(R.id.imageView)
        val detalle: Button = findViewById(R.id.b_detalle)


       // foto.setImageResource(R.mipmap.flaco)
        var br = BroadCast()



        calcular.setOnClickListener(View.OnClickListener {
            foto.setImageResource(calcularIMC(peso.text.toString().toDouble(), altura.text.toString().toDouble()))
        })

        detalle.setOnClickListener(View.OnClickListener {
            val intento : Intent = Intent(this,Detalle::class.java)
            intento.putExtra("persona",persona) // pasamos el objeto persona ya cargado
            startActivity(intento)
        })


        wifiSwitch = findViewById(R.id.switch1)
        wifiManager = applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager
        wifiSwitch.setOnCheckedChangeListener { _, isChecked ->

                if (isChecked) {
                    wifiManager.isWifiEnabled = true
                    wifiSwitch.text = "WiFi is ON"
                } else {
                    wifiManager.isWifiEnabled = false
                    wifiSwitch.text = "WiFi is OFF"
                }


        }


    }



    fun  calcularIMC(peso:Double, altura:Double) : Int{

        val res = peso / ( altura * altura)
        persona.peso=peso
        persona.altura=altura
        // res -> calculo del imc
        if(res <= 18.4){
            persona.detalle = "bajo peso"
            // esta bajo peso
            return R.mipmap.flaco
        }else if(res >= 18.5 && res < 25){
            persona.detalle="peso normal"
           return R.mipmap.normal
        }else if( res >= 25 && res <=29.9) {
            persona.detalle="sobre peso"
            return R.mipmap.gordo
        }else{
            persona.detalle="gordo morbido mil!"
            return R.mipmap.extragordo
        }

    }


    override fun onStart() {
        super.onStart()
        val intentFilter = IntentFilter(WifiManager.WIFI_STATE_CHANGED_ACTION)
        registerReceiver(wifiStateReceiver, intentFilter)
    }
    override fun onStop() {
        super.onStop()
        unregisterReceiver(wifiStateReceiver)
    }
    private val wifiStateReceiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            when (intent.getIntExtra(WifiManager.EXTRA_WIFI_STATE,
                WifiManager.WIFI_STATE_UNKNOWN)) {
                WifiManager.WIFI_STATE_ENABLED -> {
                    wifiSwitch.isChecked = true
                    wifiSwitch.text = "WiFi is ON"
                    Toast.makeText(this@MainActivity, "Wifi is On", Toast.LENGTH_SHORT).show()
                }
                WifiManager.WIFI_STATE_DISABLED -> {
                    wifiSwitch.isChecked = false
                    wifiSwitch.text = "WiFi is OFF"
                    Toast.makeText(this@MainActivity, "Wifi is Off", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

}