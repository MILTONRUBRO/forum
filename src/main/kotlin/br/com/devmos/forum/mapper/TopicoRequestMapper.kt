package br.com.devmos.forum.mapper

import br.com.devmos.forum.dto.TopicoRequestDTO
import br.com.devmos.forum.model.Topico
import br.com.devmos.forum.service.CursoService
import br.com.devmos.forum.service.UsuarioService

class TopicoRequestMapper(
    private val cursoService: CursoService,
    private val usuarioService: UsuarioService,
): Mapper<TopicoRequestDTO, Topico>{

    override fun map(t: TopicoRequestDTO): Topico {
        return Topico(
            titulo = t.titulo,
            mensagem = t.mensagem,
            curso = cursoService.buscarCursoPorId(t.idCurso),
            usuario = usuarioService.buscarUsuarioPorId(t.idUsuario)
        )
    }

}
