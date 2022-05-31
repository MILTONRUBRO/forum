package br.com.devmos.forum.controller

import br.com.devmos.forum.dto.TopicoRequestDTO
import br.com.devmos.forum.dto.TopicoResponseDTO
import br.com.devmos.forum.model.Topico
import br.com.devmos.forum.service.TopicoService
import org.springframework.web.bind.annotation.*

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
    fun salvarTopico(@RequestBody dto: TopicoRequestDTO){
        topicoService.salvarTopico(dto)
    }
}