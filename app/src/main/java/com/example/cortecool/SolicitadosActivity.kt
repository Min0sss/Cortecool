package com.example.cortecool

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cortecool.Adaptadores.CorteAdaptador
import com.example.cortecool.Controlers.CorteDAO
// 1. Importamos la clase de binding generada para activity_solicitados.xml
import com.example.cortecool.databinding.ActivitySolicitadosBinding

class SolicitadosActivity : AppCompatActivity() {

    // 2. Definimos la variable para el binding
    private lateinit var binding: ActivitySolicitadosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 3. Inicializamos el binding
        binding = ActivitySolicitadosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val crud = CorteDAO(this)

        // Obtenemos la lista de datos desde el controlador
        val mi_lista = crud.BotonListarP()

        // Configuramos el adaptador
        val mi_adaptador = CorteAdaptador(this, R.layout.item, mi_lista)

        // 4. Accedemos al ListView (o el componente lvcorte) mediante binding
        binding.lvcorte.adapter = mi_adaptador
    }
}