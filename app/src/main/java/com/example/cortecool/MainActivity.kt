package com.example.cortecool

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
// Importamos la clase de binding generada para activity_main.xml
import com.example.cortecool.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // Variable para gestionar el acceso a los componentes del XML de forma segura
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inicialización del binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}