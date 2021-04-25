package br.com.stdioh.helloworld

import io.micronaut.runtime.Micronaut.build

fun main(args: Array<String>) {

    build()
        .args(*args)
        .packages("br.com.stdioh.helloworld")
        .start()
}

