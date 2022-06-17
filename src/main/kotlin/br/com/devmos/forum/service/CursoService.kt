package br.com.devmos.forum.service

import br.com.devmos.forum.model.Curso
import br.com.devmos.forum.repository.CursoRepository
import org.springframework.stereotype.Service

@Service
class CursoService(private val cursoRepository: CursoRepository) {

    fun buscarCursoPorId(id: Long): Curso{
        return cursoRepository.findById(id).orElseThrow{throw IllegalArgumentException("Curso não encontrado")}
    }
}
