package br.com.devmos.forum.mapper

import br.com.devmos.forum.dto.TopicoResponseDTO
import br.com.devmos.forum.model.Topico
import org.springframework.stereotype.Component

@Component
class TopicoResponseMapper: Mapper<Topico, TopicoResponseDTO> {

    override fun map(t: Topico): TopicoResponseDTO {
        return TopicoResponseDTO(
            id = t.id,
            titulo = t.titulo,
            mensagem = t.mensagem,
            dataCriacao = t.dataCriacao,
            status = t.status
        )
    }
}