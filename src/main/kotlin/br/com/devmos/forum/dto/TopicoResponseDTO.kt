package br.com.devmos.forum.dto

import br.com.devmos.forum.model.StatusTopico
import java.time.LocalDateTime

data class TopicoResponseDTO(
                val id: Long?,
                val titulo: String,
                val mensagem: String,
                val status: StatusTopico,
                val dataCriacao: LocalDateTime
)
