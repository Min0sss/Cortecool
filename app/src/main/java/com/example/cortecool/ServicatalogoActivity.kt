package com.example.cortecool

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
// Importación de la clase binding generada para este layout
import com.example.cortecool.databinding.ActivityServicatalogoBinding

class ServicatalogoActivity : AppCompatActivity() {

    // Variable para gestionar el acceso a los componentes del XML
    private lateinit var binding: ActivityServicatalogoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inicialización del binding y configuración de la vista
        binding = ActivityServicatalogoBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    // Boton Cortes
    fun BotonCortes(s: View) {
        val q = Intent(this, CatalocortesActivity::class.java)
        startActivity(q)
    }

    // Boton Servicios
    fun BotonServicios(a: View) {
        val q = Intent(this, ServiciosActivity::class.java)
        startActivity(q)
    }

    fun BotonSalir(s: View) {
        finishAffinity()
    }
}