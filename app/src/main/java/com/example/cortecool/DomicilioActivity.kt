package com.example.cortecool

import android.app.TimePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.cortecool.Controlers.CorteDAO
import com.example.cortecool.Model.Domicilio
// 1. Importación del binding generado para activity_domicilio.xml
import com.example.cortecool.databinding.ActivityDomicilioBinding
import java.util.*

class DomicilioActivity : AppCompatActivity()
{
    // Variables de lógica de negocio
    private var normal: Double = 0.0
    private var escolar: Double = 0.0
    private var militar: Double = 0.0
    private var moderno: Double = 0.0
    private var cortePrecio: Double = 0.0

    // 2. Definición del objeto binding
    private lateinit var binding: ActivityDomicilioBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)

        // 3. Inicialización de View Binding
        binding = ActivityDomicilioBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val cal = Calendar.getInstance()
        val dia = cal.get(Calendar.DAY_OF_MONTH)
        val mes = cal.get(Calendar.MONTH)
        val anio = cal.get(Calendar.YEAR)
        val hora = cal.get(Calendar.HOUR_OF_DAY)
        val minuto = cal.get(Calendar.MINUTE)

        // 4. Acceso a componentes mediante binding y uso de String Templates
        binding.TVFECHA.text = "$dia/${mes + 1}/$anio"
        binding.EDTHORA.setText("$hora:$minuto")

        binding.BTNHORA.setOnClickListener {
            val tp = TimePickerDialog(this, { _, hourOfDay, minute ->
                binding.EDTHORA.setText("$hourOfDay:$minute")
            }, hora, minuto, false)
            tp.show()
        }
    }

    fun BotonRegresar(a: View)
    {
        val q = Intent(this, ServiciosActivity::class.java)
        startActivity(q)
    }

    fun BotonConfirmar(a: View)
    {
        var tipoCorte = ""

        // 5. Verificación de RadioButtons usando binding
        if (binding.RDBNORMALD.isChecked)
        {
            tipoCorte = "Normal"
        }
        else if (binding.RDBESCOLARD.isChecked)
        {
            tipoCorte = "Escolar"
        }
        else if(binding.RDBMILITARD.isChecked)
        {
            tipoCorte = "Militar"
        }
        else if(binding.RDBMODERNOD.isChecked)
        {
            tipoCorte = "Moderno"
        }

        val crud = CorteDAO(this)
        val obj = Domicilio(
            tipoCorte,
            binding.TVFECHA.text.toString(),
            binding.EDTHORA.text.toString()
        )
        crud.GrabarDomicilio(obj)

        Toast.makeText(this, "Nueva Solicitud Grabada Correctamente", Toast.LENGTH_LONG).show()
    }
}