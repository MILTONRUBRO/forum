package br.com.devmos.forum.mapper

interface Mapper<T, U> {
    fun map(t : T): U
}
