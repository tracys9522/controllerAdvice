package com.example.controllerAdvice.business.validation.validator

import com.example.controllerAdvice.business.validation.annotation.GenderValidation
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

class GenderValidator : ConstraintValidator<GenderValidation, String> {
    override fun isValid(gender: String, p1: ConstraintValidatorContext) =
        gender.matches(regex = Regex("^F|M$"))
}