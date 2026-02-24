package com.example.cortecool.Controlers

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DataBaseHelper(context: Context) :
    SQLiteOpenHelper(context, "BDCORTECOOL", null, 2) { // Subimos a versión 2 para asegurar limpieza

    // Usamos constantes para evitar errores de escritura y facilitar mantenimiento
    companion object {
        private const val TABLA_REGISTRO = "create table IF NOT EXISTS registro(" +
                "dni_usuario INTEGER PRIMARY KEY," +
                "nombres_usuario TEXT," +
                "apellidos_usuario TEXT," +
                "sexo_usuario TEXT," +
                "direccion_usuariou TEXT," +
                "celular_usuario INTEGER," +
                "eli_usuario INTEGER);"

        private const val TABLA_DOMICILIO = "create table IF NOT EXISTS domicilio(" +
                "servicio_cortes TEXT," +
                "fecha TEXT," +
                "hora TEXT);"

        private const val TABLA_RESERVA = "create table IF NOT EXISTS reserva(" +
                "r_servicio_cortes TEXT," +
                "r_fecha TEXT," +
                "r_hora TEXT);"

        // Datos semilla (Seed data) actualizados
        private const val INS_USUARIO1 = "insert into registro values(47105247, 'Elena Sharon', 'Ramirez Pacheco', 'Femenino', 'Av. La marina 2457', 982147415, 0);"
        private const val INS_DOMICILIO1 = "insert into domicilio values('Normal', '18/02/2026', '12:00');"
        private const val INS_RESERVA1 = "insert into reserva values('Escolar', '19/02/2026', '12:00');"
    }

    override fun onCreate(db: SQLiteDatabase) {
        // Creación de tablas
        db.execSQL(TABLA_REGISTRO)
        db.execSQL(TABLA_DOMICILIO)
        db.execSQL(TABLA_RESERVA)

        // Inserción de datos iniciales
        db.execSQL(INS_USUARIO1)
        db.execSQL(INS_DOMICILIO1)
        db.execSQL(INS_RESERVA1)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // En 2026, lo ideal es manejar la actualización sin cerrar la app
        if (oldVersion < newVersion) {
            db.execSQL("DROP TABLE IF EXISTS registro")
            db.execSQL("DROP TABLE IF EXISTS domicilio")
            db.execSQL("DROP TABLE IF EXISTS reserva")
            onCreate(db)
        }
    }
}