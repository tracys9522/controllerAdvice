package com.example.controllerAdvice.business

import com.example.controllerAdvice.business.model.ConstraintRequest
import com.example.controllerAdvice.business.model.MethodArgRequest
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class ExampleController {
    @PostMapping("/methodArgNotValid1")
    fun methodArgumentNotValidException(@RequestBody @Validated methodArgRequest: MethodArgRequest) {

    }

    @PostMapping("/methodArgNotValid2")
    fun constraintViolation(@RequestBody @Validated constraintRequest: ConstraintRequest) {

    }
}