package br.com.stdioh.helloworld.model

import io.micronaut.core.annotation.Introspected
import java.util.*
import javax.persistence.*

@Entity
@Introspected
class Todo(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    @Column
    val description: String,
    @Column
    val done: Boolean

) : ModelBasic() {

}