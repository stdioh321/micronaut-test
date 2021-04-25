package graal.test.controller;


import io.micronaut.http.HttpResponse
import io.micronaut.http.MutableHttpResponse
import io.micronaut.http.annotation.*
import java.util.*
import javax.inject.Inject
import javax.validation.Valid

@Controller(value = "/")
class TodoController() {
    @Get
    fun todoGet(): MutableHttpResponse<*>{
            return HttpResponse.ok("Todo");
    }   
}