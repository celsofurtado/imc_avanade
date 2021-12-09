package br.com.fiap.imc20.repository

import br.com.fiap.imc20.model.Pesagem
import java.time.LocalDate

class PesagemRepository {

    companion object {

        fun getPesagens(): List<Pesagem> {
            val pesagens = mutableListOf<Pesagem>(

                Pesagem(54,
                    LocalDate.of(2021, 12, 1),
                    "Levemente acima do peso", 27.6),

                Pesagem(
                    statusImc = "Peso Ideal",
                    peso = 71,
                    imc = 26.0,
                    data = LocalDate.of(2021, 12, 5)),

                Pesagem(94,
                LocalDate.of(2021,1, 14),
                "Obesidade II",
                31.4),

                Pesagem(94,
                    LocalDate.of(2021,1, 14),
                    "Obesidade II",
                    31.4),

                Pesagem(94,
                    LocalDate.of(2021,1, 14),
                    "Obesidade II",
                    31.4),

                Pesagem()
            )

            return pesagens
        }

    }

}