package com.istea.clase6.modelo

import java.io.Serializable

data class User(var email:String, var password:String, var nombre:String, var fuma : Boolean,var sexo:String, var profesion:String) :Serializable