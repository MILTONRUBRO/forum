package br.com.devmos.forum.service

import br.com.devmos.forum.dto.AtualizaTopicoDTO
import br.com.devmos.forum.dto.TopicoPorCategoriaDto
import br.com.devmos.forum.dto.TopicoRequestDTO
import br.com.devmos.forum.dto.TopicoResponseDTO
import br.com.devmos.forum.exception.NotFoundException
import br.com.devmos.forum.mapper.TopicoRequestMapper
import br.com.devmos.forum.mapper.TopicoResponseMapper
import br.com.devmos.forum.model.Topico
import br.com.devmos.forum.repository.TopicoRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*
import java.util.stream.Collectors

@Service
class TopicoService(private val topicoRepository: TopicoRepository,
                    private val topicoResponseMapper: TopicoResponseMapper,
                    private val topicoRequestMapper: TopicoRequestMapper,
                    private val notFoundMessage: String = "Topico não encontrado"
) {

    fun listar(nomeCurso: String?, paginacao: Pageable): Page<TopicoResponseDTO> {
        val topicos = if (nomeCurso == null){
            topicoRepository.findAll(paginacao)
        }else{
            topicoRepository.findByCursoNome(nomeCurso, paginacao)
        }
        return topicos.map { t -> topicoResponseMapper.map(t) }
    }

    fun buscarPorId(id: Long): Topico {
        return topicoRepository.findById(id).orElseThrow{NotFoundException(notFoundMessage)}
    }

    @Transactional
    fun salvarTopico(dto: TopicoRequestDTO): TopicoResponseDTO {
        val topico = topicoRequestMapper.map(dto)
        topicoRepository.save(topico)
        return topicoResponseMapper.map(topico)
    }

    @Transactional
    fun atualizarTopico(id: Long, dto: AtualizaTopicoDTO){

        val topico = topicoRepository.findById(id)
            .orElseThrow{NotFoundException(notFoundMessage)}

        topico.titulo = dto.titulo
        topico.mensagem = dto.mensagem
        topicoRepository.save(topico)
    }

    @Transactional
    fun deletarTopico(id: Long) {
        val topico = topicoRepository.findById(id)
            .orElseThrow{NotFoundException(notFoundMessage)}

        topicoRepository.delete(topico)
    }

    fun buscarRelatorios():  List<TopicoPorCategoriaDto> {
        return topicoRepository.buscarRelatorios()
    }

}

