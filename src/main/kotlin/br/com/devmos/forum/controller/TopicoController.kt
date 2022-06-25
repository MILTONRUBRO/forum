package br.com.devmos.forum.controller

import br.com.devmos.forum.dto.AtualizaTopicoDTO
import br.com.devmos.forum.dto.TopicoRequestDTO
import br.com.devmos.forum.dto.TopicoResponseDTO
import br.com.devmos.forum.model.Topico
import br.com.devmos.forum.service.TopicoService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import java.net.URI
import javax.validation.Valid

@RestController
@RequestMapping("/topicos")
class TopicoController(private val topicoService: TopicoService) {

    @GetMapping
    fun listar(@RequestParam(required = false) nomeCurso: String?): List<TopicoResponseDTO> {
        return topicoService.listar(nomeCurso)
    }

    @GetMapping("/{id}")
    fun buscarTopicoPorId(@PathVariable id: Long): Topico {
        return topicoService.buscarPorId(id)
    }

    @PostMapping
    fun salvarTopico(@RequestBody @Valid dto: TopicoRequestDTO, uriBuilder: UriComponentsBuilder): ResponseEntity<TopicoResponseDTO>{
        val response = topicoService.salvarTopico(dto)
        val uri = uriBuilder.path("/topicos/${response.id}").build().toUri()
        return ResponseEntity.created(uri).body(response)
    }

    @PutMapping("/{id}")
    fun atualizarTopico(@PathVariable id: Long, @RequestBody @Valid dto: AtualizaTopicoDTO){
        topicoService.atualizarTopico(id, dto)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deletarTopico(@PathVariable id: Long){
        topicoService.deletarTopico(id)
    }
}