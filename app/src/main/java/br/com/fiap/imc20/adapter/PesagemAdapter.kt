package br.com.fiap.imc20.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import br.com.fiap.imc20.R
import br.com.fiap.imc20.model.Pesagem
import br.com.fiap.imc20.utils.converteDataParaBrasil

class PesagemAdapter(val listaPesagem: List<Pesagem>, val context: Context): RecyclerView.Adapter<PesagemAdapter.PesagemHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PesagemHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_pesagem_layout, parent, false)

        return PesagemHolder(view)
    }

    override fun onBindViewHolder(holder: PesagemHolder, position: Int) {
        var pesagem = listaPesagem[position]
        holder.textViewDataPesagem.text = converteDataParaBrasil(pesagem.data)
        holder.textViewImc.text = "${pesagem.imc}"
        holder.textViewPeso.text = "${pesagem.peso}Kg"
        holder.textViewStatusImc.text = pesagem.statusImc

        holder.textViewImc.setOnClickListener {
            Toast.makeText(context, "${holder.textViewImc.text}", Toast.LENGTH_SHORT).show()
        }

    }

    override fun getItemCount() = listaPesagem.size

    class PesagemHolder(view: View): RecyclerView.ViewHolder(view) {

        var textViewDataPesagem = view.findViewById<TextView>(R.id.tv_data_pesagem)
        var textViewPeso = view.findViewById<TextView>(R.id.tv_peso_layout)
        var textViewStatusImc = view.findViewById<TextView>(R.id.tv_status_imc)
        var textViewImc = view.findViewById<TextView>(R.id.tv_valor_imc)

    }

}