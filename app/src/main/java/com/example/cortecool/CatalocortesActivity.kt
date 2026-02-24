package com.example.cortecool

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
// 1. Importamos la clase de binding generada para este layout
import com.example.cortecool.databinding.ActivityCatalocortesBinding

class CatalocortesActivity : AppCompatActivity() {

    // 2. Definimos la variable para el binding
    private lateinit var binding: ActivityCatalocortesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 3. Inflamos el layout usando View Binding
        binding = ActivityCatalocortesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 4. (Opcional) Si el botón en el XML tiene el ID 'btnAtras',
        // puedes configurar el click aquí mismo para mayor orden:
        // binding.btnAtras.setOnClickListener { BotonAtras(it) }
    }

    // Boton ATRÁS
    fun BotonAtras(s: View) {
        val q = Intent(this, ServicatalogoActivity::class.java)
        startActivity(q)
    }
}