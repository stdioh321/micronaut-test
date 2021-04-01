package br.com.stdioh.helloworld.model

import io.micronaut.core.annotation.Introspected
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.validation.constraints.Size

@Entity
@Introspected
class User(
    @Id
    var cpf: Long,
    @Column @Size(min = 6)
    var password: String
) {

}