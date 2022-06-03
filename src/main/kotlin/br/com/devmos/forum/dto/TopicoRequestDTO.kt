package br.com.devmos.forum.dto

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size
import kotlin.math.min

data class TopicoRequestDTO(

    @field:NotEmpty(message = "Titulo não pode ser vazio")
    @field:Size(min = 5, max = 100)
    val titulo: String,

    @field:NotEmpty(message = "Mensagem não pode ser vazia")
    val mensagem: String,

    @field:NotNull(message = "id do curso não pode ser nulo")
    val idCurso: Long,

    @field:NotNull(message = "id do usuario não pode ser nulo")
    val idUsuario: Long
)