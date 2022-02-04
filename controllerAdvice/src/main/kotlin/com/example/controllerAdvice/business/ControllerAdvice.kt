package com.example.controllerAdvice.business

import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import javax.validation.ConstraintViolationException

@RestControllerAdvice
class ControllerAdvice(private val exceptionService: ExceptionService) : ResponseEntityExceptionHandler() {
    /**
     * request param constraint violation
     * handle general invalid format exceptions for validators
     */
    @ExceptionHandler(ConstraintViolationException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleConstraintViolation(
        ex: ConstraintViolationException, request: WebRequest?
    ) = exceptionService.handleUncaughtException(ex)

    /**
     * missing parameter
     */
//    override fun handleMissingServletRequestParameter(
//        ex: MissingServletRequestParameterException,
//        headers: HttpHeaders,
//        status: HttpStatus,
//        request: WebRequest
//    )

    /**
     * BeanValidation exception
     * request body invalid format exceptions
     */
    override fun handleMethodArgumentNotValid(
        ex: MethodArgumentNotValidException, headers: HttpHeaders, status: HttpStatus, request: WebRequest
    ) = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionService.handleUncaughtException(ex))


    /**
     * multipart/form-data missing exceptions
     */
//    override fun handleMissingServletRequestPart(
//        ex: MissingServletRequestPartException,
//        headers: HttpHeaders,
//        status: HttpStatus,
//        request: WebRequest
//    )

    /**
     * Missing Request Header
     * type mismatch
     * illegal argument
     */
//    @ExceptionHandler(
//        MissingRequestHeaderException::class,
//        MethodArgumentTypeMismatchException::class,
//        IllegalArgumentException::class
//    )
//    fun handleMissingRequestHeaderException(
//        ex: Exception,
//    )

}