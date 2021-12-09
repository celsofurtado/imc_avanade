package br.com.fiap.imc20.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.fiap.imc20.R
import br.com.fiap.imc20.adapter.PesagemAdapter
import br.com.fiap.imc20.repository.PesagemRepository

class MainActivity : AppCompatActivity() {

    private lateinit var rvPesagens: RecyclerView
    private lateinit var pesagemAdapter: PesagemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvPesagens = findViewById(R.id.rv_pesagens)

        // Obter os dados que serão carregados na Recycler
        pesagemAdapter = PesagemAdapter(PesagemRepository.getPesagens(), this)

        // Definir o layout/orientação da RecyclerView
        rvPesagens.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        rvPesagens.adapter = pesagemAdapter



    }
}