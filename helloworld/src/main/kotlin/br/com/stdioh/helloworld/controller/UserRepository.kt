package br.com.stdioh.helloworld.controller

import br.com.stdioh.helloworld.config.security.BCryptPasswordEncoderService
import br.com.stdioh.helloworld.model.User
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository

@Repository
abstract class UserRepository : JpaRepository<User, Long> {


}