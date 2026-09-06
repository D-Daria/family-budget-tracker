package com.personal.budgettracker.repository

import com.personal.budgettracker.entity.Transaction
import org.springframework.data.jpa.repository.JpaRepository

interface TransactionRepository: JpaRepository<Transaction, Long> {

    fun findByAccountId(accountId: Long): List<Transaction>
}