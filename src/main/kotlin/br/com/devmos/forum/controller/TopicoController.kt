package br.com.devmos.forum.controller

import br.com.devmos.forum.dto.AtualizaTopicoDTO
import br.com.devmos.forum.dto.TopicoRequestDTO
import br.com.devmos.forum.dto.TopicoResponseDTO
import br.com.devmos.forum.model.Topico
import br.com.devmos.forum.service.TopicoService
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/topicos")
class TopicoController(private val topicoService: TopicoService) {

    @GetMapping
    fun listar(): List<TopicoResponseDTO> {
        return topicoService.listar()
    }

    @GetMapping("/{id}")
    fun buscarTopicoPorId(@PathVariable id: Long): Topico{
        return topicoService.buscarPorId(id)
    }

    @PostMapping
    fun salvarTopico(@RequestBody @Valid dto: TopicoRequestDTO){
        topicoService.salvarTopico(dto)
    }

    @PutMapping("/{id}")
    fun atualizarTopico(@PathVariable id: Long, @RequestBody @Valid dto: AtualizaTopicoDTO){
        topicoService.atualizarTopico(id, dto)
    }

    @DeleteMapping("/{id}")
    fun deletarTopico(@PathVariable id: Long){
        topicoService.deletarTopico(id)
    }
}