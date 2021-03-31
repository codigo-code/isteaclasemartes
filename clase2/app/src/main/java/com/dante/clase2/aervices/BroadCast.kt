package com.dante.clase2.aervices

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.wifi.WifiManager
import android.widget.Toast

class BroadCast : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val msg = "broacast" + intent?.action




        when(intent?.getIntExtra(WifiManager.EXTRA_WIFI_STATE,WifiManager.WIFI_STATE_UNKNOWN)){
            WifiManager.WIFI_STATE_ENABLED->{
                Toast.makeText(context,"wifi On",Toast.LENGTH_LONG).show()
            }
            WifiManager.WIFI_STATE_DISABLED->{
                Toast.makeText(context,"wifi of",Toast.LENGTH_LONG).show()
            }
        }
    }
}