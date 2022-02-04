package com.example.controllerAdvice.business.model

import java.io.Serializable
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Pattern

data class MethodArgRequest(
    @field:NotEmpty(message = "name must not be empty. ")
    var name: String?,
    @field:Pattern(regexp = "(^F|M$)", message = "gender must be either F or M")
    var sex: String
) : Serializable

