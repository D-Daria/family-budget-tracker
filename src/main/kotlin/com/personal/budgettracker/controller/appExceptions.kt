package com.personal.budgettracker.controller


data class ErrorResponse(
    val message: String?,
    val statusCode: String
)

class NotFoundException(message: String?) : RuntimeException(message)