package com.personal.budgettracker.controller

import com.personal.budgettracker.dto.TransactionRequest
import com.personal.budgettracker.service.TransactionService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/transactions")
class TransactionController(
    private val transactionService: TransactionService
) {

    @PostMapping("/{accountId}")
    fun createTransaction(@PathVariable accountId: Long, @Valid @RequestBody transactionReq: TransactionRequest) {
        transactionService.createTransaction(accountId, transactionReq)
    }
}