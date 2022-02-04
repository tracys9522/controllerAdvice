package com.example.controllerAdvice.business.model

import com.example.controllerAdvice.business.validation.annotation.GenderValidation
import com.example.controllerAdvice.business.validation.annotation.NameValidation
import java.io.Serializable

data class ConstraintRequest(
    @NameValidation
    var name: String?,

    @GenderValidation
    var sex: String
) : Serializable

