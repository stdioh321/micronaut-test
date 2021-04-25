package br.com.stdioh.helloworld.config

import br.com.stdioh.helloworld.config.security.BCryptPasswordEncoderService
import br.com.stdioh.helloworld.model.Todo
import br.com.stdioh.helloworld.model.User
import br.com.stdioh.helloworld.repository.TodoRepository
import br.com.stdioh.helloworld.repository.UserRepository
import io.micronaut.context.annotation.Value
import io.micronaut.context.event.StartupEvent
import io.micronaut.runtime.event.annotation.EventListener
import org.slf4j.LoggerFactory
import javax.inject.Singleton

@Singleton
class StartupService(
    private val userRepository: UserRepository,
    private val bc: BCryptPasswordEncoderService,
    private val todoRepository: TodoRepository
) {
    private val log = LoggerFactory.getLogger(StartupService::class.java)

    @Value("\${test:Nothing Found}")
    private var test: String? = null

    @EventListener
    fun onStartupEvent(event: StartupEvent) {
        val cpf: Long = 12309812309;
        log.info("---------------------------------------------------------------")
        log.info("Startup test: $test")
        log.info("---------------------------------------------------------------")

        if (userRepository.findById(cpf).isEmpty) {
            val user = userRepository.save(
                User(cpf, bc.encode("123456"))
            )
            log.info("Usuario adicionado: ${user}");
        }

    }

    @EventListener
    fun onStartupEventAddTodos(event: StartupEvent) {
        if (todoRepository.count() < 1) {
            for (i in 1..3) {
                todoRepository.save(
                    Todo(description = "Startup Todo - $i", done = i % 2 == 0)
                )
            }
        }

    }
}