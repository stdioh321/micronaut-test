package br.com.stdioh.helloworld.repository

import br.com.stdioh.helloworld.model.Todo
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository

@Repository
interface TodoRepository : JpaRepository<Todo, Long> {
}