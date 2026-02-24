package com.example.cortecool

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.cortecool.Controlers.CorteDAO
import com.example.cortecool.Model.Usuario
// 1. IMPORTANTE: Eliminamos el import de synthetic y usamos el binding generado
import com.example.cortecool.databinding.ActivityRegistroBinding

class RegistroActivity : AppCompatActivity()
{
    // 2. Declaramos la variable para el binding
    private lateinit var binding: ActivityRegistroBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        // 3. Inicializamos el binding
        binding = ActivityRegistroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 4. Configuramos los listeners manualmente (opcional, pero recomendado en lugar de 'onClick' en XML)
        binding.btnRegistrar.setOnClickListener { BotonRegistrarR(it) }
        binding.btnSalir.setOnClickListener { BotonSalir(it) }
    }

    fun BotonRegistrarR(g: View)
    {
        var sexo: String = ""
        // 5. Ahora accedemos a través de 'binding'
        if (binding.rdbF.isChecked)
        {
            sexo = "Femenino"
        }
        else if (binding.rdbF.isChecked)
        {
            sexo = "Masculino"
        }

        val crud = CorteDAO(this)
        val nomb = binding.edtNombres.text.toString()

        // Manejo de seguridad para evitar errores al convertir a Int si el campo está vacío
        val dni = binding.edtDni.text.toString().toIntOrNull() ?: 0
        val celular = binding.edtCelular.text.toString().toIntOrNull() ?: 0

        val obj = Usuario(
            dni,
            nomb,
            binding.edtApellidos.text.toString(),
            sexo,
            binding.edtDirecPri.text.toString(),
            celular,
            0
        )

        crud.GrabarRegistro(obj)
        Toast.makeText(this, "Usuario ${nomb} registrado correctamente", Toast.LENGTH_LONG).show()

        val m = Intent(this, ServicatalogoActivity::class.java)
        startActivity(m)
    }

    fun BotonSalir(s: View)
    {
        val alertsalida = AlertDialog.Builder(this)
        alertsalida.setTitle("Confirmar cierre")
        alertsalida.setMessage("¿Desea salir de la aplicación?")

        alertsalida.setPositiveButton("SI") { _, _ ->
            finishAffinity()
        }

        alertsalida.setNegativeButton("NO") { dialog, _ ->
            dialog.dismiss()
        }
        alertsalida.show()
    }
}