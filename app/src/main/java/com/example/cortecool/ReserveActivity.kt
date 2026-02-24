package com.example.cortecool

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.cortecool.Controlers.CorteDAO
import com.example.cortecool.Model.Reserva
// 1. Nueva importación para View Binding
import com.example.cortecool.databinding.ActivityReserveBinding
import java.util.*

class ReserveActivity : AppCompatActivity() {

    // 2. Definición del objeto binding
    private lateinit var binding: ActivityReserveBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 3. Inicialización de View Binding
        binding = ActivityReserveBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val cal = Calendar.getInstance()
        val dia = cal.get(Calendar.DAY_OF_MONTH)
        val mes = cal.get(Calendar.MONTH)
        val anio = cal.get(Calendar.YEAR)
        val hora = cal.get(Calendar.HOUR_OF_DAY)
        val minuto = cal.get(Calendar.MINUTE)

        // 4. Acceso a componentes mediante binding
        binding.EDTFECHAR.setText("$dia/${mes + 1}/$anio")
        binding.EDTHORAR.setText("$hora:$minuto")

        binding.EDTFECHAR.setOnClickListener {
            val dp = DatePickerDialog(this, { _, year, month, dayOfMonth ->
                binding.EDTFECHAR.setText("$dayOfMonth/${month + 1}/$year")
            }, anio, mes, dia)
            dp.show()
        }

        binding.BTNHORAR.setOnClickListener {
            val tp = TimePickerDialog(this, { _, hourOfDay, minute ->
                binding.EDTHORAR.setText("$hourOfDay:$minute")
            }, hora, minuto, false)
            tp.show()
        }

        // Configuramos el listener del botón confirmar
        binding.BTNCONFIRMAR.setOnClickListener { BotonConfirmar(it) }
    }

    fun BotonRegresar(a: View) {
        val q = Intent(this, ServiciosActivity::class.java)
        startActivity(q)
    }

    fun BotonConfirmar(h: View) {
        var corte = ""

        // 5. Verificación de RadioButtons usando binding
        if (binding.RDBNORMALR.isChecked) {
            corte = "Normal"
        } else if (binding.RDBESCOLARR.isChecked) {
            corte = "Escolar"
        } else if (binding.RDBMILITARR.isChecked) {
            corte = "Militar"
        } else if (binding.RDBMODERNOR.isChecked) {
            corte = "Moderno"
        }

        val crud = CorteDAO(this)
        val objr = Reserva(
            corte,
            binding.EDTFECHAR.text.toString(),
            binding.EDTHORAR.text.toString()
        )
        crud.GrabarReserva(objr)

        Toast.makeText(this, "Nueva Solicitud Grabada Correctamente", Toast.LENGTH_LONG).show()
    }
}