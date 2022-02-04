package com.example.controllerAdvice.business.validation.annotation

import javax.validation.Constraint
import javax.validation.Payload
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import kotlin.reflect.KClass

@Target(AnnotationTarget.FUNCTION, AnnotationTarget.FIELD, AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = [])
@MustBeDocumented
@NotEmpty
@NotNull
annotation class NameValidation(
    val message: String = "Name must not be empty. ",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = []
)