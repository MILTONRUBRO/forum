package br.com.devmos.forum.controller

import br.com.devmos.forum.dto.AtualizaTopicoDTO
import br.com.devmos.forum.dto.TopicoPorCategoriaDto
import br.com.devmos.forum.dto.TopicoRequestDTO
import br.com.devmos.forum.dto.TopicoResponseDTO
import br.com.devmos.forum.model.Topico
import br.com.devmos.forum.service.TopicoService
import org.slf4j.LoggerFactory
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.Cacheable
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import java.net.URI
import javax.validation.Valid

@RestController
@RequestMapping("/topicos")
class TopicoController(private val topicoService: TopicoService) {

    private val logger = LoggerFactory.getLogger(this::class.java)

    @GetMapping
    @Cacheable("topicos")
    fun listar(@RequestParam(required = false) nomeCurso: String?,
               @PageableDefault(size = 10, sort = ["dataCriacao"], direction = Sort.Direction.DESC) paginacao: Pageable): Page<TopicoResponseDTO> {
        return topicoService.listar(nomeCurso, paginacao)
    }

    @GetMapping("/{id}")
    fun buscarTopicoPorId(@PathVariable id: Long): Topico {
        logger.info("ID: {}", id)
        return topicoService.buscarPorId(id)
    }

    @PostMapping
    @CacheEvict(value = ["topicos"], allEntries = true)
    fun salvarTopico(@RequestBody @Valid dto: TopicoRequestDTO, uriBuilder: UriComponentsBuilder): ResponseEntity<TopicoResponseDTO>{
        logger.info("Request: {}", dto)
        val response = topicoService.salvarTopico(dto)
        val uri = uriBuilder.path("/topicos/${response.id}").build().toUri()
        return ResponseEntity.created(uri).body(response)
    }

    @PutMapping("/{id}")
    @CacheEvict(value = ["topicos"], allEntries = true)
    fun atualizarTopico(@PathVariable id: Long, @RequestBody @Valid dto: AtualizaTopicoDTO){
        logger.info("Request: {}", dto)
        topicoService.atualizarTopico(id, dto)
    }

    @DeleteMapping("/{id}")
    @CacheEvict(value = ["topicos"], allEntries = true)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deletarTopico(@PathVariable id: Long){
        topicoService.deletarTopico(id)
    }

    @GetMapping("/relatorios")
    fun buscarRelatorios():  List<TopicoPorCategoriaDto>{
        return topicoService.buscarRelatorios()
    }
}