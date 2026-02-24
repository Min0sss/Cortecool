package com.example.cortecool.Controlers

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import com.example.cortecool.Model.Domicilio
import com.example.cortecool.Model.Reserva
import com.example.cortecool.Model.Usuario
import com.example.cortecool.Model.Vista

class CorteDAO(contexto: Context) {
    private val helper = DataBaseHelper(contexto)

    fun GrabarRegistro(obj: Usuario) {
        val db: SQLiteDatabase = helper.writableDatabase
        // Usamos ContentValues para evitar errores con comillas en los nombres
        val valores = ContentValues().apply {
            put("dni_usuario", obj.dni_usuario)
            put("nombres_usuario", obj.nombres_usuario)
            put("apellidos_usuario", obj.apellidos_usuario)
            put("sexo_usuario", obj.sexo_usuario)
            put("direccion_usuariou", obj.direccion_usuariou)
            put("celular_usuario", obj.celular_usuario)
            put("eli_usuario", obj.eli_usuario)
        }

        db.insert("registro", null, valores)
        db.close()
    }

    fun GrabarDomicilio(obj: Domicilio) {
        val db: SQLiteDatabase = helper.writableDatabase
        val valores = ContentValues().apply {
            put("servicio_cortes", obj.servicio_cortes)
            put("fecha", obj.fecha)
            put("hora", obj.hora)
        }

        db.insert("domicilio", null, valores)
        db.close()
    }

    fun GrabarReserva(obj: Reserva) {
        val db: SQLiteDatabase = helper.writableDatabase
        val valores = ContentValues().apply {
            put("r_servicio_cortes", obj.r_servicio_cortes)
            put("r_fecha", obj.r_fecha)
            put("r_hora", obj.r_hora)
        }

        db.insert("reserva", null, valores)
        db.close()
    }

    fun BotonListarP(): ArrayList<Vista> {
        val lista = ArrayList<Vista>()
        val db: SQLiteDatabase = helper.readableDatabase
        val consulta = "SELECT nombres_usuario, direccion_usuariou, celular_usuario FROM registro"

        // El bloque .use cierra automáticamente el cursor al terminar, incluso si hay un error
        db.rawQuery(consulta, null).use { cursor ->
            while (cursor.moveToNext()) {
                val obj = Vista(
                    cursor.getString(0),
                    cursor.getString(1),
                    cursor.getInt(2)
                )
                lista.add(obj)
            }
        }
        db.close()
        return lista
    }
}