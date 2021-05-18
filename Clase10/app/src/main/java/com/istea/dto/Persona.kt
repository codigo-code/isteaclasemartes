package com.istea.dto

import java.io.Serializable

data class Persona(val nombre: String, val dni: String ): Serializable

// binario

/*

     C#

     class Persona{

        string id {get;set;}
        string nombre {get;set;}

     }

     al serializar lo transformo en binario
     01010100101  ---> guardarlo en algun lado --->  base de datos
                                                     memoria del sistema
                                                     mapa ---> putExtra(K,obj)

     obj ---> estrcutra de clases + su valores

     var p = new Persona("dante",123);

     p.getNombre() -> String

     p ---> serializado en 010101001011


 */