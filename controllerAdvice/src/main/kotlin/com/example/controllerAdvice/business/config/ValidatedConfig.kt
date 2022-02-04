package com.example.controllerAdvice.business.config

import org.hibernate.validator.HibernateValidator
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.validation.Validation
import javax.validation.Validator

import javax.validation.ValidatorFactory

/**
 * spit out the first error from validate instead of going through all
 */
@Configuration
class ValidatedConfig {
    @Bean
    fun validator(): Validator {
        val validatorFactory: ValidatorFactory = Validation.byProvider(HibernateValidator::class.java)
            .configure()
            .failFast(false)
            .buildValidatorFactory()
        return validatorFactory.validator
    }
}