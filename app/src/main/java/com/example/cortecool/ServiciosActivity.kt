package com.example.cortecool

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
// Importamos la clase de binding generada para activity_servicios.xml
import com.example.cortecool.databinding.ActivityServiciosBinding

class ServiciosActivity : AppCompatActivity() {

    // Variable para gestionar el acceso a los componentes del XML de forma segura
    private lateinit var binding: ActivityServiciosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inicialización del binding
        binding = ActivityServiciosBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    // Boton Salir - Regresa al catálogo de servicios
    fun BotonSalir(s: View) {
        val q = Intent(this, ServicatalogoActivity::class.java)
        startActivity(q)
    }

    // Boton Reserve
    fun BotonReserve(a: View) {
        val q = Intent(this, ReserveActivity::class.java)
        startActivity(q)
    }

    // Boton Domicilio
    fun BotonDomicilio(v: View) {
        val q = Intent(this, DomicilioActivity::class.java)
        startActivity(q)
    }

    // Boton Solicitados
    fun BotonSolicitados(w: View) {
        val q = Intent(this, SolicitadosActivity::class.java)
        startActivity(q)
    }

    // Boton Contactanos
    fun BotonContactanos(e: View) {
        val q = Intent(this, ContactanosActivity::class.java)
        startActivity(q)
    }

    // Boton Usuarios
    fun BotonUsuarios(w: View) {
        val q = Intent(this, SolicitadosActivity::class.java)
        startActivity(q)
    }
}