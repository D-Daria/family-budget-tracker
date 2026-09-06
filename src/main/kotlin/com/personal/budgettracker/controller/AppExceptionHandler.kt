package com.personal.budgettracker.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice


@RestControllerAdvice
class AppExceptionHandler {

    @ExceptionHandler(NotFoundException::class)
    fun handleNotFoundException(ex: NotFoundException) =
        ResponseEntity(ErrorResponse(
            ex.message, HttpStatus.NOT_FOUND.toString()),
            HttpStatus.NOT_FOUND
        )

}