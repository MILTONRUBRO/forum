package br.com.devmos.forum.service

import br.com.devmos.forum.model.UserDetail
import br.com.devmos.forum.model.Usuario
import br.com.devmos.forum.repository.UsuarioRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service
import java.lang.IllegalArgumentException

@Service
class UsuarioService(private val usuarioRepository: UsuarioRepository) : UserDetailsService {

    fun buscarUsuarioPorId(id: Long): Usuario{
        return usuarioRepository.findById(id).orElseThrow{IllegalArgumentException("Usuario não encontrado")}
    }

    override fun loadUserByUsername(username: String?): UserDetails {
        val usuario = usuarioRepository.findByEmail(username) ?: throw RuntimeException()
        return UserDetail(usuario)
    }

}
