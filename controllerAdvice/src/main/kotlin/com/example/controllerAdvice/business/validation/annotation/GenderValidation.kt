package com.example.controllerAdvice.business.validation.annotation

import com.example.controllerAdvice.business.validation.validator.GenderValidator
import javax.validation.Constraint
import javax.validation.Payload
import kotlin.reflect.KClass

@Target(AnnotationTarget.FUNCTION, AnnotationTarget.FIELD, AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = [GenderValidator::class])
@MustBeDocumented
annotation class GenderValidation(
    val message: String = "Gender must be F or M. ",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = []
)