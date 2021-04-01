package br.com.stdioh.helloworld.config

import br.com.stdioh.helloworld.config.security.BCryptPasswordEncoderService
import br.com.stdioh.helloworld.controller.UserRepository
import br.com.stdioh.helloworld.model.User
import io.micronaut.context.event.StartupEvent
import io.micronaut.runtime.event.annotation.EventListener
import org.slf4j.LoggerFactory
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import javax.inject.Singleton

@Singleton
class StartupService(
    private val userRepository: UserRepository,
    private val bc: BCryptPasswordEncoderService
) {
    private val log = LoggerFactory.getLogger(StartupService::class.java)

    @EventListener
    fun onStartupEvent(event: StartupEvent) {
        val cpf: Long = 12309812309;

        if (userRepository.findById(cpf).isEmpty) {
            val user = userRepository.save(
                User(cpf, bc.encode("123456"))
            )
            log.info("Usuario adicionado: ${user}");
        }

    }
}