package com.cistea.api

import com.cistea.model.StartWar
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiStarWar {

    @GET(".")
    fun getPersonaje(): Call<StartWar>

    companion object{

        fun create() : ApiStarWar{

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://swapi.dev/api/people/1/")
                .build()
            return retrofit.create(ApiStarWar::class.java)
        }

    }
}