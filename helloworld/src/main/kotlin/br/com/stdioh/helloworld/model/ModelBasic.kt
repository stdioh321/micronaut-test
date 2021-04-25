package br.com.stdioh.helloworld.model

import io.micronaut.core.annotation.Introspected
import io.micronaut.data.annotation.MappedEntity
import java.util.*
import javax.persistence.Column

@MappedEntity
@Introspected
abstract class ModelBasic {
    @Column(name = "created_at")
    var createdAt: Date? = null

    @Column(name = "updated_at")
    var updatedAt: Date? = null

    @Column(name = "deleted_at")
    var deletedAt: Date? = null

    init {
        val d = Date();
        createdAt = d;
        updatedAt = d;
    }

    fun update(entity: ModelBasic): Boolean {
        if (this.javaClass != entity.javaClass) return false;
        try {
            this.javaClass.declaredFields.forEach { f1 ->
                f1.trySetAccessible();
                val f1Name = f1.name;
                val f1Value = f1.get(this);

                val f2 = entity.javaClass.getDeclaredField(f1Name);
                f2.trySetAccessible();
                val f2Value = f2.get(entity);
                if (f2Value != null)
                    f1.set(this, f2Value);

            };
            return true;
        } catch (ex1: Exception) {
            ex1.printStackTrace();
        }
        return false;
    }

}