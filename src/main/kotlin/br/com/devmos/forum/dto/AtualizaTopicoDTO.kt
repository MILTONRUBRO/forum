package br.com.devmos.forum.dto

import javax.validation.constraints.NotEmpty

data class AtualizaTopicoDTO(

    @field:NotEmpty(message = "Titulo não pode ser vazio")
    val titulo: String,

    @field:NotEmpty(message = "Mensagem não pode ser vazia")
    val mensagem: String
        ) {

}
