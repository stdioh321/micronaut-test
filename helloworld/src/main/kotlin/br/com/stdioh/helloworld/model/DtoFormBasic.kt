package br.com.stdioh.helloworld.model

abstract class DtoFormBasic<T> {

    abstract fun toOriginal(): T
    abstract fun fromOriginal(entity: T): DtoFormBasic<T>

}