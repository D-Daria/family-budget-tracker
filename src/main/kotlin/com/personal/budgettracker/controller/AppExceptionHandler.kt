package com.personal.budgettracker.controller

import jakarta.persistence.EntityNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice


@RestControllerAdvice
class AppExceptionHandler {

    @ExceptionHandler(NotFoundException::class, EntityNotFoundException::class)
    fun handleNotFoundException(ex: Exception) =
        ResponseEntity(ErrorResponse(
            ex.message, HttpStatus.NOT_FOUND.toString()),
            HttpStatus.NOT_FOUND
        )

    @ExceptionHandler(InsufficientFundsException::class)
    fun handleInsufficientFundsException(ex: Exception) =
        ResponseEntity(ErrorResponse(
            ex.message, HttpStatus.BAD_REQUEST.toString()),
            HttpStatus.BAD_REQUEST
        )


    @ExceptionHandler(Exception::class)
    fun handleCommonExceptions(ex: Exception) =
        ResponseEntity(ErrorResponse(
            ex.message, HttpStatus.BAD_REQUEST.toString()),
            HttpStatus.BAD_REQUEST
        )

}