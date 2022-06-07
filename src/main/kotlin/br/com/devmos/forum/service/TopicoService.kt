package br.com.devmos.forum.service

import br.com.devmos.forum.dto.AtualizaTopicoDTO
import br.com.devmos.forum.dto.TopicoRequestDTO
import br.com.devmos.forum.dto.TopicoResponseDTO
import br.com.devmos.forum.mapper.TopicoRequestMapper
import br.com.devmos.forum.mapper.TopicoResponseMapper
import br.com.devmos.forum.model.Curso
import br.com.devmos.forum.model.Topico
import br.com.devmos.forum.model.Usuario
import org.springframework.stereotype.Service
import java.util.*
import java.util.stream.Collectors

@Service
class TopicoService(private var topicos: List<Topico>,
                    private val topicoResponseMapper: TopicoResponseMapper,
                    private val topicoRequestMapper: TopicoRequestMapper
) {

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
        return topicos.stream().map { t -> topicoResponseMapper.map(t) }.collect(Collectors.toList())
    }

    fun buscarPorId(id: Long): Topico {
        return topicos.stream().filter{ t ->  t.id == id}
            .findFirst()
            .orElseThrow{throw IllegalArgumentException("Topico não encontrado")}
    }

    fun salvarTopico(dto: TopicoRequestDTO) {
        val topico = topicoRequestMapper.map(dto)
        topico.id = topicos.size.toLong() + 1
        topicos = topicos.plus(topico)
    }

    fun atualizarTopico(id: Long, dto: AtualizaTopicoDTO){

        val topico = topicos.stream().filter{t -> t.id == id}
            .findFirst()
            .orElseThrow{throw IllegalArgumentException("Topico não encontrado")}

        topicos = topicos.minus(topico).plus(Topico(
            id = id,
            titulo = dto.titulo,
            mensagem = dto.mensagem,
            usuario = topico.usuario,
            curso = topico.curso,
            status = topico.status,
            respostas = topico.respostas,
            dataCriacao = topico.dataCriacao
        ))
    }

    fun deletarTopico(id: Long) {
        val topico = topicos.stream().filter{t -> t.id == id}
            .findFirst()
            .orElseThrow{throw IllegalArgumentException("Topico não encontrado")}

        topicos = topicos.minus(topico)

    }


}