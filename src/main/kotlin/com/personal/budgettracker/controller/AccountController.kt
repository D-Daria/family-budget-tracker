package com.personal.budgettracker.controller

import com.personal.budgettracker.dto.AccountRequest
import com.personal.budgettracker.dto.AccountResponse
import com.personal.budgettracker.dto.TransactionResponse
import com.personal.budgettracker.dto.toResponse
import com.personal.budgettracker.entity.Account
import com.personal.budgettracker.repository.AccountRepository
import com.personal.budgettracker.repository.TransactionRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/accounts")
class AccountController(
    private val accountRepository: AccountRepository,
    private val transactionRepository: TransactionRepository
) {

    @PostMapping
    fun createAccount(@RequestBody accountReq: AccountRequest): ResponseEntity<AccountResponse> {
        val newAcc = Account(
            name = accountReq.name,
            currency = accountReq.currency
        )

        val saved = accountRepository.save(newAcc)

        return ResponseEntity.status(HttpStatus.CREATED).body(saved.toResponse())
    }

    @GetMapping("/{id}")
    fun getAccountById(@PathVariable("id") id: Long): ResponseEntity<AccountResponse> =
        ResponseEntity.ok(getAccountResponseById(id))

    @GetMapping("/{id}/transactions")
    fun getAllTransactionsFromAccount(
        @PathVariable("id") id: Long
    ): ResponseEntity<List<TransactionResponse>> {
        getAccountResponseById(id)

        return ResponseEntity.ok(
            transactionRepository.findByAccountId(id).map { it.toResponse() }
        )
    }

    private fun getAccountResponseById(id: Long) =
        accountRepository.findByIdOrNull(id)?.toResponse()
            ?: throw NotFoundException("Account with id $id not found")
}