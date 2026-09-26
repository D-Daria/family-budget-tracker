package com.personal.budgettracker.dto

import com.personal.budgettracker.entity.Currency
import java.math.BigDecimal
import java.time.Instant

data class AccountRequest(
    val name: String,
    val currency: Currency
)

data class AccountResponse(
    val id: Long?,
    val name: String,
    val currency: Currency,
    val balance: BigDecimal,
    val createdAt: Instant
)

data class TransactionResponse(
    val id: Long?,
    val accountId: Long?,
    val amount: BigDecimal,
    val category: String,
    val description: String?,
    val timestamp: Instant
)

data class TransactionRequest(
    val amount: BigDecimal
)