package br.com.stdioh.helloworld

import io.micronaut.runtime.Micronaut.*
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

fun main(args: Array<String>) {

	build()
	    .args(*args)
		.packages("br.com.stdioh.helloworld")
		.start()

}






