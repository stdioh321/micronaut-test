package br.com.stdioh.helloworld.model.form

import br.com.stdioh.helloworld.model.DtoFormBasic
import br.com.stdioh.helloworld.model.Todo
import io.micronaut.core.annotation.Introspected
import java.time.Instant
import java.util.*
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

@Introspected
class TodoPostForm : DtoFormBasic<Todo>() {
    @NotNull
    @Size(min = 3)
    @NotEmpty
    var description: String = ""
    var done: Boolean = false


    override fun toOriginal(): Todo =
        Todo(description = this.description, done = this.done)

    override fun fromOriginal(todo: Todo): TodoPostForm {
        return TodoPostForm().apply {
            this.description = todo.description
            this.done = todo.done
        }
    }


}