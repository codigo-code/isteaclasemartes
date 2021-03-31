package com.dante.clase3.model

import java.io.Serializable


// data class representa a una clase simple del modelo donde solo va a tener atributos con su getter y setter
data class Pelicula(val titulo:String, val genero:String, val url: String):Serializable