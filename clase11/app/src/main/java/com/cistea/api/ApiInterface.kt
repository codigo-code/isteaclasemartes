package com.cistea.api

import com.cistea.model.StartWar
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {

    @GET("api/people/{id}")
    fun getPersonaje(@Path("id") id: Int) :Call<StartWar>

}