package br.com.stdioh.helloworld

import io.micronaut.runtime.Micronaut.build

fun main(args: Array<String>) {

    build()
        .args(*args)
        .packages("br.com.stdioh.helloworld")
        .start()
    Car.tmp = "Jao";


    var c1 = Car("Carro");
    var c2 = Car("Carro");


    println("c1: ${c1}, ${c1.hashCode()}")
    println("c2: ${c2}, ${c2.hashCode()}")



    if (c1 == c2)
        println("EQUAL")
    else
        println("DIFERENT")
    doSomething(listOf("abc", "bcd", "cde", "abby"));

    listOf("a", "b", "c", null)
        .filterNotNull()
        .find {
            it.toLowerCase().startsWith("a");
        }.also {
            println(it);
        }

}


data class Car(var name: String) {
    companion object {
        var tmp = "abc";
    }
}


fun doSomething(list: List<String>, predicate: ((String) -> Boolean)? = null) {
    list.forEach {
        if (predicate?.invoke(it) == true) {
            println(it);
        }
    }
}
