package com.example.cortecool.Adaptadores

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.cortecool.Model.Vista
// 1. Importamos el binding generado para el layout 'item.xml'
import com.example.cortecool.databinding.ItemBinding

class CorteAdaptador(context: Context, resource: Int, objects: ArrayList<Vista>)
    : ArrayAdapter<Vista>(context, resource, objects)
{
    private var mi_contexto: Context = context
    private var mi_recurso: Int = resource
    private var mi_lista = objects

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        // 2. Usamos View Binding para inflar el elemento de la lista
        val binding: ItemBinding
        val rowView: View

        if (convertView == null) {
            binding = ItemBinding.inflate(LayoutInflater.from(mi_contexto), parent, false)
            rowView = binding.root
            rowView.tag = binding
        } else {
            binding = convertView.tag as ItemBinding
            rowView = convertView
        }

        val objrest = mi_lista[position]

        // 3. Asignamos los datos usando el objeto binding
        binding.TVNOMBREUSUARIO.text = objrest.nombres_usuario
        binding.TVDIRECCION.text = "Dirección: ${objrest.direccion_usuariou}"
        binding.TVCELULAR.text = "Celular: ${objrest.celular_usuario}"

        return rowView
    }
}