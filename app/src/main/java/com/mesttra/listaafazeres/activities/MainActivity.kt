package com.mesttra.listaafazeres.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mesttra.listaafazeres.R
import com.mesttra.listaafazeres.adapters.TarefasAdapter
import com.mesttra.listaafazeres.models.Tarefa

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var recyclerView = findViewById<RecyclerView>(R.id.lista_tarefas)
        recyclerView.adapter = TarefasAdapter(tarefas(), this)
        val layoutManager = LinearLayoutManager(this)
//        val layoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
        recyclerView.layoutManager = layoutManager

    }

    private fun tarefas(): List<Tarefa> {
        return listOf(
            Tarefa("Leitura", "Livro de Kotlin com Android"),
            Tarefa("Pesquisa", "Como posso melhorar o código dos meus projetos"),
            Tarefa("Estudo", "Como sincronizar minha App com um Web Service")
        )
    }

    fun mostrarDetalhes(position: Int) {

        val tarefa: Tarefa = tarefas()[position]

        val intent = Intent(this, DetailActivity::class.java).apply {
            putExtra("titulo", tarefa.titulo)
            putExtra("descricao", tarefa.descricao)
        }

        startActivity(intent)

//        val posicaoCorreta = position + 1
//        Toast.makeText(this, "Celula clicada na posição " + posicaoCorreta + " !", Toast.LENGTH_SHORT).show()
    }
}