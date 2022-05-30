package br.com.devmos.forum.dto

data class TopicoRequestDTO(
    val titulo: String,
    val mensagem: String,
    val idCurso: Long,
    val idUsuario: Long
)