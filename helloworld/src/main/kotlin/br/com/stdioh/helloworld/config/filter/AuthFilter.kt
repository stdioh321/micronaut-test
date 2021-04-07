package br.com.stdioh.helloworld.config.filter

import io.micronaut.http.HttpRequest
import io.micronaut.http.MutableHttpResponse
import io.micronaut.http.annotation.Filter
import io.micronaut.http.filter.HttpServerFilter
import io.micronaut.http.filter.ServerFilterChain
import org.reactivestreams.Publisher

@Filter("/**")
class AuthFilter : HttpServerFilter {
    override fun doFilter(request: HttpRequest<*>?, chain: ServerFilterChain): Publisher<MutableHttpResponse<*>> {
        println("AuthFilter");
        println(request);
        request?.attributes?.put("test" , "testttt");
        return chain.proceed(request);

    }
}