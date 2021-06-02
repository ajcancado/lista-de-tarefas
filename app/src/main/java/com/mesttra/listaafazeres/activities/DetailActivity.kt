package com.mesttra.listaafazeres.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.mesttra.listaafazeres.R

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // Acesso aos compoenentes da tela via 'findViewById'
        val tituloTextView = findViewById<TextView>(R.id.titulo_tarefa)
        val descricaoTextView = findViewById<TextView>(R.id.descricao_tarefa)

        // Acesso aos parâmetros passados pela tela anterior
        // note que acessamos exatamente as mesmas chaves definidas na tela anterior ( titulo + descricao )
        val titulo = intent.getStringExtra("titulo")
        val descricao = intent.getStringExtra("descricao")

        // Colocamos a informação listada na tela anteriror nos componentes da tela
        tituloTextView.text = titulo
        descricaoTextView.text = descricao
    }
}