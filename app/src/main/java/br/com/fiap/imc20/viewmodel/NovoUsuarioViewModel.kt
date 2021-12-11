package br.com.fiap.imc20.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.fiap.imc20.model.Pesagem

class NovoUsuarioViewModel: ViewModel() {

    val peso = MutableLiveData<Int>()
    val pesoString = MutableLiveData<String>()
    val listaPesagem = MutableLiveData<List<Pesagem>>()

    init {
        peso.value = 0
        pesoString.value = "${peso.value}Kg"
    }

    fun exibePeso() {



        pesoString.value = "${peso.value}Kg"
    }

}