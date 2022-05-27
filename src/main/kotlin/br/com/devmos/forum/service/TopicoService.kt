package br.com.devmos.forum.service

import br.com.devmos.forum.model.Curso
import br.com.devmos.forum.model.Topico
import br.com.devmos.forum.model.Usuario
import org.springframework.stereotype.Service
import java.util.*

@Service
class TopicoService(private var topicos: List<Topico>) {

    init {
        val topico = Topico(
            id = 1,
            titulo = "Duvida Kotlin",
            mensagem = "Variaveis no Kotlin",
            curso = Curso(
                id = 1,
                nome = "Kotlin",
                categoria = "Programacao"
            ),
            usuario = Usuario(
                id = 1,
                nome = "Ana da Silva",
                email = "ana@email.com"
            )
        )

        val topico2 = Topico(
            id = 2,
            titulo = "Duvida Kotlin 2",
            mensagem = "Variaveis no Kotlin 2",
            curso = Curso(
                id = 1,
                nome = "Kotlin",
                categoria = "Programacao"
            ),
            usuario = Usuario(
                id = 1,
                nome = "Ana da Silva",
                email = "ana@email.com"
            )
        )
        topicos =  Arrays.asList(topico, topico2)

    }
    fun listar(): List<Topico> {
        return topicos
    }
}