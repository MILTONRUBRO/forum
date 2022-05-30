package br.com.devmos.forum.service

import br.com.devmos.forum.model.Usuario
import org.springframework.stereotype.Service
import java.lang.IllegalArgumentException
import java.util.*

@Service
class UsuarioService(private var usuarios: List<Usuario>) {

    init {

        val usuario = Usuario(
            id = 1,
            nome = "Lagertha",
            email = "lagertha@email"
        )

        usuarios = Arrays.asList(usuario)
    }

    fun buscarUsuarioPorId(id: Long): Usuario{
        return usuarios.stream()
                        .filter({u -> u.id == id})
                        .findFirst()
                        .orElseThrow({IllegalArgumentException("Usuario não encontrado")})
    }
}
