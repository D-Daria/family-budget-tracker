package com.personal.budgettracker.controller

import com.personal.budgettracker.dto.AccountRequest
import com.personal.budgettracker.dto.AccountResponse
import com.personal.budgettracker.dto.TransactionResponse
import com.personal.budgettracker.service.AccountService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/accounts")
class AccountController(
    private val accountService: AccountService
) {

    @PostMapping
    fun createAccount(@RequestBody accountReq: AccountRequest): ResponseEntity<AccountResponse> =
        ResponseEntity.status(HttpStatus.CREATED).body(accountService.createAccount(accountReq))

    @GetMapping("/{id}")
    fun getAccountById(@PathVariable("id") id: Long): ResponseEntity<AccountResponse> =
        ResponseEntity.ok(accountService.getAccountById(id))

    @GetMapping("/{id}/transactions")
    fun getAllTransactionsFromAccount(
        @PathVariable("id") id: Long
    ): ResponseEntity<List<TransactionResponse>> =
        ResponseEntity.ok(
            accountService.getAllTransactionsFromAccount(id)
        )
}