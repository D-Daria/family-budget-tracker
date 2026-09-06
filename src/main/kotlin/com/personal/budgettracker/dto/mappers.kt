package com.personal.budgettracker.dto

import com.personal.budgettracker.entity.Account
import com.personal.budgettracker.entity.Transaction

fun Account.toResponse(): AccountResponse =
    AccountResponse(
        id = this.id,
        name = this.name,
        currency = this.currency,
        balance = this.balance,
        createdAt = this.createdAt
    )

fun Transaction.toResponse(): TransactionResponse =
    TransactionResponse(
        id = this.id,
        accountId = this.account.id,
        amount = this.amount,
        category = this.category,
        description = this.description,
        timestamp = this.timestamp
    )