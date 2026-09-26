package com.personal.budgettracker.dto

import com.personal.budgettracker.entity.AccountEntity
import com.personal.budgettracker.entity.TransactionEntity

fun AccountEntity.toResponse(): AccountResponse =
    AccountResponse(
        id = this.id,
        name = this.name,
        currency = this.currency,
        balance = this.balance,
        createdAt = this.createdAt
    )

fun TransactionEntity.toResponse(): TransactionResponse =
    TransactionResponse(
        id = this.id,
        accountId = this.account.id,
        amount = this.amount,
        category = this.category,
        description = this.description,
        timestamp = this.timestamp
    )