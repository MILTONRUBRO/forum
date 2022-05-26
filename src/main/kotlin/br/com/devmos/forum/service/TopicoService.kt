package br.com.devmos.forum.service

import br.com.devmos.forum.model.Curso
import br.com.devmos.forum.model.Topico
import br.com.devmos.forum.model.Usuario
import org.springframework.stereotype.Service
import java.util.*

@Service
class TopicoService {
    fun listar(): List<Topico> {

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
        return Arrays.asList(topico, topico, topico)
    }
}