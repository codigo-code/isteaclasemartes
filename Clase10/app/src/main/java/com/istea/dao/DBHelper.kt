package com.istea.dao

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.istea.dto.Persona

class DBHelper(context: Context, factory: SQLiteDatabase.CursorFactory?) : SQLiteOpenHelper(context, DATABASE_NAME, factory, DATABASE_VERSION) {



    companion object{
        private val DATABASE_NAME: String = "persona.db"
        private val DATABASE_VERSION: Int = 1
        val TABLA_PERSONA = "persona"
        val COLUMN_ID = "id"
        val COLUMN_NOMBRE="nombre"
        val COLUMN_DNI="dni"
    }

    override fun onCreate(db: SQLiteDatabase?) {
    // las tablas en nuestra base de datos
        val CREATE_PERSONA_TABLE = ("CREATE TABLE " +
                TABLA_PERSONA + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY," +
                COLUMN_NOMBRE
                + " TEXT," + COLUMN_DNI + " TEXT" + ")")

        db?.execSQL(CREATE_PERSONA_TABLE);
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

        if(oldVersion != newVersion){
            db?.execSQL("DROP TABLE TABLE IF EXIST"+ TABLA_PERSONA )
            onCreate(db)
        }
    }

    fun guardarPersona(p: Persona){

        val db = this.writableDatabase

        val values = ContentValues()
        values.put(COLUMN_NOMBRE, p.nombre)
        values.put(COLUMN_DNI, p.dni)

        db.insert(TABLA_PERSONA,null,values)
    }


    fun obtenerPersonas():ArrayList<Persona>{

        val query = "SELECT * FROM "+ TABLA_PERSONA
        val listaPersona: ArrayList<Persona> = ArrayList<Persona>()
        val db = this.readableDatabase

        val cursor: Cursor = db.rawQuery(query,null)

        if(cursor.moveToFirst()){

            do {
                val nom = cursor.getString(cursor.getColumnIndex("nombre"))
                val dni = cursor.getString(cursor.getColumnIndex("dni"))
                listaPersona.add(Persona(nom,dni))
            }while(cursor.moveToNext())
        }

        return listaPersona
    }


}