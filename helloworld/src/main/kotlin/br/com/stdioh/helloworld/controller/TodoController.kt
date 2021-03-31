package br.com.stdioh.helloworld.controller

import br.com.stdioh.helloworld.model.Todo
import br.com.stdioh.helloworld.model.form.TodoPostForm
import br.com.stdioh.helloworld.repository.TodoRepository
import io.micronaut.http.HttpResponse
import io.micronaut.http.MutableHttpResponse
import io.micronaut.http.annotation.*
import io.micronaut.validation.Validated
import javax.inject.Inject
import javax.validation.Valid

@Validated
@Controller(value = "/")
class TodoController(@Inject val todoRepository: TodoRepository) {
    @Get
    fun todoGet(): List<Todo?> {
        return todoRepository.findAll();
    }

    @Get("/{id}")
    fun todoGetById(@PathVariable("id") id: Long): MutableHttpResponse<Todo> {
        val todo = todoRepository.findById(id);
        if (todo?.isPresent)
            return HttpResponse.ok(todo.get());
        else
            return HttpResponse.notFound();

    }

    @Post
    fun todoPost(@Body @Valid todo: TodoPostForm): Todo {

        return todoRepository.save(todo.toOriginal());
    }
}