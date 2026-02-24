package com.example.cortecool.Model

data class Usuario(var dni_usuario: Int, var nombres_usuario:String, var apellidos_usuario: String,
                   var sexo_usuario: String, var direccion_usuariou: String, var celular_usuario:Int, var  eli_usuario:Int)

data class Domicilio(var servicio_cortes:String, var fecha:String, var hora:String)

data class Reserva(var r_servicio_cortes:String, var r_fecha:String, var r_hora:String)

