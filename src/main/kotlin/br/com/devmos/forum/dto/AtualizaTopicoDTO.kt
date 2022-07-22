package br.com.devmos.forum.dto

import javax.validation.constraints.NotEmpty

data class AtualizaTopicoDTO(

    @field:NotEmpty(message = "O Titulo não pode ser vazio")
    val titulo: String,

    @field:NotEmpty(message = "A Mensagem não pode ser vazia")
    val mensagem: String
        ) {

}
