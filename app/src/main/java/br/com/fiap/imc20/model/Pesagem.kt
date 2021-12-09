package br.com.fiap.imc20.model

import java.time.LocalDate

data class Pesagem(
    var peso: Int = 0,
    var data: LocalDate = LocalDate.now(),
    var statusImc: String = "",
    var imc: Double = 0.0
)
