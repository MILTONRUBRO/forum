package br.com.devmos.forum.service

import br.com.devmos.forum.model.Usuario
import br.com.devmos.forum.repository.UsuarioRepository
import org.springframework.stereotype.Service
import java.lang.IllegalArgumentException

@Service
class UsuarioService(private val usuarioRepository: UsuarioRepository) {

    fun buscarUsuarioPorId(id: Long): Usuario{
        return usuarioRepository.findById(id).orElseThrow{IllegalArgumentException("Usuario não encontrado")}
    }
}
