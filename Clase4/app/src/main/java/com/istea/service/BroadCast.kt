package com.istea.service

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.wifi.WifiManager
import android.widget.Toast

class BroadCast : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {

        when(intent?.getIntExtra(WifiManager.EXTRA_WIFI_STATE,WifiManager.WIFI_STATE_UNKNOWN)){

            WifiManager.WIFI_STATE_ENABLED->{
                Toast.makeText(context, "wifi activo puuede seguir trabajando...",Toast.LENGTH_LONG).show()
            }

            WifiManager.WIFI_STATE_DISABLED->{
                Toast.makeText(context, "wifi fue desconectado la aplicacion dejo de operar....",Toast.LENGTH_LONG).show()

            }
        }
    }
}