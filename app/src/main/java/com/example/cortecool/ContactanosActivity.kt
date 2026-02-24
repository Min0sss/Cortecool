package com.example.cortecool

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
// Importamos la clase de binding generada para activity_contactanos.xml
import com.example.cortecool.databinding.ActivityContactanosBinding

class ContactanosActivity : AppCompatActivity() {

    // Variable para gestionar el acceso a los componentes del XML de forma segura
    private lateinit var binding: ActivityContactanosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inicialización del binding
        binding = ActivityContactanosBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    // Botón Regresar - Regresa a la pantalla de servicios
    fun BotonRegresar(a: View) {
        val q = Intent(this, ServiciosActivity::class.java)
        startActivity(q)
    }
}