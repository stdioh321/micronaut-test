package br.com.stdioh.helloworld.controller

import br.com.stdioh.helloworld.model.Todo
import io.micronaut.context.annotation.Configuration
import io.micronaut.context.annotation.Requires
import io.micronaut.http.HttpHeaderValues
import io.micronaut.http.HttpHeaders
import io.micronaut.http.HttpRequest
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.RequestAttribute

@Controller("/")

class HelloController {

    @Get
    public fun helloGet(req: HttpRequest<*>): String {
        req.attributes.forEach {
            println("${it.key} - ${it.value}");
        }
        println(Todo::description)
        return "Hello World";
    }
}