package br.com.stdioh.helloworld.controller

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller("/")
class HelloController {

    @Get
    public fun helloGet(): String {
        return "Hello World";
    }
}