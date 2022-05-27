package br.com.devmos.forum.controller

import br.com.devmos.forum.model.Topico
import br.com.devmos.forum.service.TopicoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/topicos")
class TopicoController(private val topicoService: TopicoService) {

    @GetMapping
    fun listar(): List<Topico> {
        return topicoService.listar()
    }

    @GetMapping("/{id}")
    fun buscarTopicoPorId(@PathVariable id: Long): Topico{
        return topicoService.buscarPorId(id)
    }
}