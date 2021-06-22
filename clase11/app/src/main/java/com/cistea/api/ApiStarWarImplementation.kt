package com.cistea.api

import android.util.Log
import android.widget.Toast
import com.cistea.model.StartWar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.coroutines.CoroutineContext

class ApiStarWarImplementation  {

    private  fun getRetrofit():Retrofit{

        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://swapi.dev/")
            .build()
    }

    fun getPersona(id :Int):Call<StartWar>{
        try {
            return getRetrofit().create(ApiInterface::class.java).getPersonaje(id)


        }catch (e:Exception){
            Log.e("error",e.message.toString(),e )
        }
        return null!!
    }
}