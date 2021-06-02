package com.mesttra.listaafazeres.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mesttra.listaafazeres.R
import com.mesttra.listaafazeres.activities.MainActivity
import com.mesttra.listaafazeres.models.Tarefa

class TarefasAdapter(private val tarefas: List<Tarefa>, private val context: Context) :
    RecyclerView.Adapter<TarefasAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cardView = itemView.findViewById<LinearLayout>(R.id.cardView)
        val titulo = itemView.findViewById<TextView>(R.id.nota_titulo)
        val descricao = itemView.findViewById<TextView>(R.id.nota_descricao)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.card_tarefa, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return tarefas.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val tarefa: Tarefa = tarefas[position]

        holder.titulo.text = tarefa.titulo
        holder.descricao.text = tarefa.descricao

        holder.cardView.setOnClickListener { (context as MainActivity).mostrarDetalhes(position) }
    }
}