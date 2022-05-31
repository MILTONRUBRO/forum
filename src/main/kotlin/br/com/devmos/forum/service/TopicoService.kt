package br.com.devmos.forum.service

import br.com.devmos.forum.dto.TopicoRequestDTO
import br.com.devmos.forum.dto.TopicoResponseDTO
import br.com.devmos.forum.model.Curso
import br.com.devmos.forum.model.Topico
import br.com.devmos.forum.model.Usuario
import org.springframework.stereotype.Service
import java.util.*
import java.util.stream.Collectors

@Service
class TopicoService(private var topicos: List<Topico>, private val cursoService: CursoService, private val usuarioService: UsuarioService) {

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
    fun listar(): List<TopicoResponseDTO> {
        return topicos.stream().map { t -> TopicoResponseDTO(
            id = t.id,
            titulo = t.titulo,
            mensagem = t.mensagem,
            dataCriacao = t.dataCriacao,
            status = t.status
        ) }.collect(Collectors.toList())
    }

    fun buscarPorId(id: Long): Topico {
        return topicos.stream().filter({ t ->  t.id == id})
            .findFirst()
            .orElseThrow({throw IllegalArgumentException("Topico não encontrado")})
    }

    fun salvarTopico(dto: TopicoRequestDTO) {
        topicos = topicos.plus(Topico(
            id = topicos.size.toLong() + 1,
            titulo = dto.titulo,
            mensagem = dto.mensagem,
            curso = cursoService.buscarCursoPorId(dto.idCurso),
            usuario = usuarioService.buscarUsuarioPorId(dto.idUsuario)
        ))
    }


}