package br.com.stdioh.helloworld.controller

import br.com.stdioh.helloworld.model.Todo
import br.com.stdioh.helloworld.model.form.TodoPostForm
import com.fasterxml.jackson.databind.ObjectMapper
import com.google.gson.Gson
import io.micronaut.http.HttpRequest
import io.micronaut.http.client.RxHttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import javax.inject.Inject

@MicronautTest
class TodoControllerTest {
    @Inject
    @field:Client("/")
    lateinit var client: RxHttpClient


    val objectMapper: ObjectMapper = ObjectMapper();

    @Test
    fun shouldReturnAListOfTodo() {
        val req: HttpRequest<Any> = HttpRequest.GET("/todo");
        val body: String = client.toBlocking().retrieve(req);
        var gson = Gson();
        var result = gson?.fromJson<List<Todo>>(body, List::class.java);
        Assertions.assertNotNull(body);
        Assertions.assertNotNull(result);
        Assertions.assertTrue(result is List<Todo>);

    }

    @Test
    fun shouldPostOneValidTodo() {
        val todoPostForm = TodoPostForm().apply {
            this.description = "new Description"
            this.done = false
        }
        val todoPostFormJson: String = objectMapper.writeValueAsString(todoPostForm);
        val req: HttpRequest<Any> = HttpRequest.POST("/todo", todoPostFormJson);
        val respTodo = client.exchange(req, String::class.java)
            .singleOrError().blockingGet()
        val todoJson = respTodo.body();
        val todo = objectMapper.readValue(todoJson, Todo::class.java);

        Assertions.assertTrue(respTodo.code() in 200..299);
        Assertions.assertNotNull(todo?.id);


    }


}