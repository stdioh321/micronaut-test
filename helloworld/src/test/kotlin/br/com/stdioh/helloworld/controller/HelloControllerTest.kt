package br.com.stdioh.helloworld.controller

import br.com.stdioh.helloworld.model.Todo
import com.google.gson.Gson
import com.sun.xml.bind.v2.TODO
import io.micronaut.http.HttpRequest
import io.micronaut.http.client.RxHttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import javax.inject.Inject

@MicronautTest
class HelloControllerTest {
    @Inject
    @field:Client("/")
    lateinit var client: RxHttpClient

    @Test
    fun testHello() {
        val req: HttpRequest<Any> = HttpRequest.GET("/");
        val body = client.toBlocking().retrieve(req);
        Assertions.assertNotNull(body);
        Assertions.assertEquals("Hello World", body);
    }


}