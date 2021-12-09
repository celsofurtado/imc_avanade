package br.com.fiap.imc20.utils

import java.time.LocalDate
import java.time.format.DateTimeFormatter

fun converteDataParaBrasil(data: LocalDate): String {

    val formato = DateTimeFormatter.ofPattern("dd/MM/yyyy")

    return data.format(formato)

}