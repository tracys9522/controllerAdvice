package com.example.controllerAdvice.business

import com.example.controllerAdvice.business.model.JsonResponseModel
import org.hibernate.validator.internal.engine.path.PathImpl
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.validation.FieldError
import org.springframework.validation.beanvalidation.SpringValidatorAdapter
import org.springframework.web.bind.MethodArgumentNotValidException
import javax.validation.ConstraintViolationException

@Service
class ExceptionService {
    private val log = LoggerFactory.getLogger(javaClass)
    fun handleUncaughtException(p0: Exception): Any {
        return when (p0) {
//            is ConstraintViolationException -> processConstraintViolationExceptions(p0)
            is MethodArgumentNotValidException -> processMethodArgumentExceptions(p0)
            else -> -1
        }
    }

    private fun processMethodArgumentExceptions(ex: MethodArgumentNotValidException): JsonResponseModel {
        ex.allErrors.onEach {
            log.info("${(it as FieldError).field}: ${it.defaultMessage}")
        }
        return JsonResponseModel(
            code = HttpStatus.BAD_REQUEST.value(),
            msgCode = HttpStatus.BAD_REQUEST.reasonPhrase
        )
    }

    private fun processConstraintViolationExceptions(ex: ConstraintViolationException): JsonResponseModel {
        ex.constraintViolations.onEach { objectError ->
            val message = (objectError.propertyPath as PathImpl).leafNode.name.let { field ->
                if (field.isNullOrEmpty()) {
                    objectError.message
                } else {
                    "${field}: ${objectError.message}"
                }
            }
            log.info(message)
        }
        return JsonResponseModel(
            code = HttpStatus.BAD_REQUEST.value(),
            msgCode = HttpStatus.BAD_REQUEST.reasonPhrase
        )
    }

}