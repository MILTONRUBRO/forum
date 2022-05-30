package br.com.devmos.forum.service

import br.com.devmos.forum.model.Curso
import org.springframework.stereotype.Service
import java.util.*

@Service
class CursoService(private var cursos: List<Curso>) {

    init{
        val curso = Curso(
            id = 1,
            nome = "Kotlin",
            categoria = "Programação"
        )

        cursos = Arrays.asList(curso)
    }

    fun buscarCursoPorId(id: Long): Curso{
        return cursos.stream()
                    .filter { curso -> curso.id == id }
                    .findFirst()
                    .orElseThrow({throw IllegalArgumentException("Curso não encontrado")})
    }

}
